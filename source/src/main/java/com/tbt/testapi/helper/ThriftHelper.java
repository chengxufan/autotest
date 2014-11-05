package com.tbt.testapi.helper;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.thrift.TApplicationException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.dom4j.Document;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.tbt.testapi.BaseHelper;
import com.tbt.testapi.EnvConfig;
import com.tbt.testapi.TestApiException;
import com.tbt.testapi.exception.HelperException;
import com.tbt.testapi.exception.StepException;
import com.tbt.testapi.utils.Utils;
import com.tongbaotu.fits.thrift.idl.Fits;
import com.tongbaotu.fits.thrift.idl.FitsException;

public class ThriftHelper extends BaseHelper {
	private static final Logger logger = LoggerFactory
			.getLogger(ThriftHelper.class);
	private String host;
	private int port;
	private String packageName;

	public Class getClass(String namespace) throws ClassNotFoundException {
		if (namespace.equals("String")
				|| namespace.equals("java.lang.String")) {
			return String.class;
		} else if (namespace.equals("int")
				|| namespace.equals("java.lang.Integer")) {
			return int.class;
		} else if (namespace.equals("double")
				|| namespace.equals("java.lang.double")) {
			return Double.class;
		}
		return Class.forName(packageName + "." + namespace);
	}

	public Object newInstance(String namespace, Element el,
			HashMap<String, Object> vars)
			throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, NoSuchFieldException,
			SecurityException, NoSuchMethodException,
			IllegalArgumentException, InvocationTargetException,
			StepException {
		// logger.debug("newInstance n " + namespace);
		// logger.debug("newInstance e " + el);
		Utils.formatElement(vars, el);
		if (namespace.equals("String")
				|| namespace.equals("java.lang.String")) {

			return el.getText();
		} else if (namespace.equals("int")
				|| namespace.equals("java.lang.Integer")) {
			return new Integer(el.getText());
		} else if (namespace.equals("double")
				|| namespace.equals("java.lang.double")) {
			return new Double(el.getText());
		}

		return newStruct(namespace, el, vars);
	}

	public Object newStruct(String type, Element el,
			HashMap<String, Object> vars)
			throws NoSuchFieldException, SecurityException,
			ClassNotFoundException, NoSuchMethodException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, InstantiationException,
			StepException {

		Object object = Class.forName(packageName + "." + type)
				.newInstance();

		List<Element> list = el.selectNodes("val");

		for (Iterator<Element> it = list.iterator(); it.hasNext();) {
			Element val = it.next();
			String valName = val.attributeValue("name");
			Field f = object.getClass().getDeclaredField(valName);
			String varType = f.getType().getName();

			if (varType.equals("java.util.Set")) {
				ParameterizedType pt = (ParameterizedType) f
						.getGenericType();
				varType = pt.getActualTypeArguments()[0]
						.toString();
				varType = varType.replace("class ", "");
				// logger.debug("varType " + varType);
			}

			Object sub = parseStruct(varType, val, vars);

			Method method = object
					.getClass()
					.getMethod("set"
							+ Utils.toUpperCaseFirstOne(valName),
							new Class[] { f.getType() });
			method.invoke(object, new Object[] { sub });
		}

		return object;
	}

	public Set<Object> parseSetStruct(String type, Element el,
			HashMap<String, Object> vars)
			throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, NoSuchFieldException,
			SecurityException, NoSuchMethodException,
			IllegalArgumentException, InvocationTargetException,
			StepException {
		Set set = new HashSet();
		List list = el.selectNodes("item");
		Object object = null;
		for (Iterator<Element> it = list.iterator(); it.hasNext();) {
			Element item = it.next();
			object = parseStruct(type, item, vars);
			set.add(object);
		}

		return set;

	}

	public Object parseStruct(String type, Element el,
			HashMap<String, Object> vars)
			throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, NoSuchFieldException,
			SecurityException, NoSuchMethodException,
			IllegalArgumentException, InvocationTargetException,
			StepException {
		String name = el.attributeValue("name");
		List<Element> list = el.selectNodes("item");
		type = type.replace(packageName + ".", "");
		// logger.debug("new type " + type);
		if (list.size() != 0) {
			return parseSetStruct(type, el, vars);
		}

		// logger.debug("name " + name);

		Object object = newInstance(type, el, vars);

		return object;
	}

	public Object parseStruct(Element el, HashMap<String, Object> vars)
			throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, NoSuchFieldException,
			SecurityException, NoSuchMethodException,
			IllegalArgumentException, InvocationTargetException,
			StepException {
		String type = el.attributeValue("type");
		return parseStruct(type, el, vars);
	}

	@Override
	public void init() throws HelperException {
		Element el = (Element) EnvConfig.getInstance().doc
				.selectSingleNode("//environment/item[@name='thrift']");
		if (el == null) {
			throw new HelperException(
					"ThriftHelper init environment config is null.");
		}
		host = el.element("host").getText();
		port = Integer.parseInt(el.element("port").getText());
		packageName = el.element("packageName").getText();

		if (host == null || port == 0 || packageName == null) {
			throw new HelperException(
					"ThriftHelper init environment config parse error.");
		}
	}

	@Override
	public void destroy() {

	}

	@Override
	public JsonObject run(Document doc, HashMap<String, Object> vars)
			throws TestApiException, HelperException,
			IllegalArgumentException, StepException {
		JsonObject jo = new JsonObject();
		try {
			Element el = (Element) doc
					.selectSingleNode("/root/item[@name='call']");

			if (el == null) {
				throw new HelperException(
						"ThriftHelper run xml parse item element is null.");
			}

			String function = el.attributeValue("function");
			TTransport transport;
			Method method = null;

			transport = new TSocket(host, port);
			transport.open();

			TProtocol protocol = new TBinaryProtocol(transport);
			Fits.Client client = new Fits.Client(protocol);

			List<Class> params = new ArrayList<Class>();
			List<Object> runParams = new ArrayList<Object>();
			List list = el.selectNodes("param");
			for (Iterator<Element> it = list.iterator(); it
					.hasNext();) {
				Element pel = it.next();
				Class c = getClass(pel.attributeValue("type"));
				Object object = parseStruct(pel, vars);
				runParams.add(object);
				params.add(c);
			}

			Class[] classParams = new Class[params.size()];

			classParams = params.toArray(classParams);
			method = client.getClass().getMethod(function,
					classParams);

			Object ret = method.invoke(client, runParams.toArray());
			logger.debug("thrift helper response obj " + ret);
			Element rel = (Element) el.selectSingleNode("ret");
			if (rel != null) {
				list = rel.selectNodes("val");
				for (Iterator<Element> retIt = list.iterator(); retIt
						.hasNext();) {

					Element rvel = retIt.next();

					String type = rvel
							.attributeValue("type");

					Field f = ret.getClass()
							.getDeclaredField(
									rvel.getText());
					method = ret.getClass()
							.getMethod("get"
									+ Utils.toUpperCaseFirstOne(rvel
											.getText()),
									new Class[] {});

					Object retObj = method.invoke(ret,
							new Object[] {});

					if (type == null) {
						String retVal = String
								.valueOf(retObj);
						logger.debug("retVal " + retVal);
						jo.addProperty(rvel
								.attributeValue("name"),
								retVal);
					} else {
						if (type.equals("list")) {
							Gson gson = new Gson();
							String jsonString = gson
									.toJson(retObj);
							// JsonParser jp = new
							// JsonParser();
							// JsonElement je = jp
							// .parse(jsonString);
							// JsonArray ja = je
							// .getAsJsonArray();
							//
							jo.addProperty(rvel
									.attributeValue("name"),
									jsonString);

						}
					}
				}

			}

			transport.close();

		} catch (InvocationTargetException e) {
			if (e.getCause() instanceof FitsException) {
				FitsException ee = (FitsException) e
						.getTargetException();
				jo.addProperty("exceptionCode", ee.getCode());
				JsonObject exceptionObject = new JsonObject();
				logger.info("thrift FitsException" + ee);
				vars.put("exception_code", ee.getCode());
				vars.put("exception_messsage", ee.getMessage());
				return jo;
			} else if (e.getCause() instanceof TTransportException) {
				TTransportException ee = (TTransportException) e
						.getTargetException();
				logger.info("thrift TTransportException" + ee);
				return null;
			} else if (e.getCause() instanceof TApplicationException) {
				TApplicationException ee = (TApplicationException) e
						.getTargetException();
				logger.info("thrift TApplicationException" + ee);
				throw new HelperException("ThriftHelper "
						+ e.getCause().getMessage());

			} else if (e.getCause() instanceof TProtocolException) {
				TProtocolException ee = (TProtocolException) e
						.getTargetException();

				throw new HelperException("ThriftHelper "
						+ e.getCause().getMessage());

			}

			logger.info("thrift InvocationTargetException"
					+ e.getCause());

		} catch (TTransportException e) {
			throw new HelperException(
					String.format("ThriftHelper connect server %s:%d error.",
							host, port));
		} catch (ClassNotFoundException e) {
			throw new HelperException("class not found "
					+ e.getMessage());
		}

		catch (InstantiationException e) {
			throw new HelperException("object not get instance "
					+ e.getMessage());
		} catch (IllegalAccessException e) {
			throw new HelperException("object not get instance "
					+ e.getMessage());
		} catch (NoSuchFieldException e) {
			throw new HelperException("field not found "
					+ e.getMessage());
		} catch (SecurityException e) {
			throw new HelperException("field not found "
					+ e.getMessage());
		} catch (NoSuchMethodException e) {
			throw new HelperException("method not found "
					+ e.getMessage());
		}

		// logger.debug("thrift helper response " + jo);

		return jo;
	}

}
