package com.tbt.testapi.helper;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.dom4j.Document;
import org.dom4j.Element;

import com.google.gson.JsonObject;
import com.tbt.testapi.BaseHelper;
import com.tbt.testapi.EnvConfig;
import com.tbt.testapi.utils.Utils;
import com.tongbaotu.fits.thrift.idl.Fits;
import com.tongbaotu.fits.thrift.idl.FitsException;

public class ThriftHelper extends BaseHelper {
	private String host;
	private int port;
	private String packageName;

	@Override
	public void init() {
		Element el = (Element) EnvConfig.getInstance().doc
				.selectSingleNode("//environment/item[@name='thrift']");
		host = el.element("host").getText();
		port = Integer.parseInt(el.element("port").getText());
		packageName = el.element("packageName").getText();

	}

	@Override
	public void destroy() {

	}

	@Override
	public JsonObject run(Document doc, HashMap<String, String> vars) {
		JsonObject jo = new JsonObject();
		try {
			Element el = (Element) doc
					.selectSingleNode("/root/item[@name='call']");
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
				String type = pel.attributeValue("type");
				Class param = Class.forName(packageName + "."
						+ type);
				Object object = Class.forName(
						packageName + "." + type)
						.newInstance();
				for (Iterator<Element> varsIt = pel
						.elementIterator("val"); varsIt
						.hasNext();) {
					Element vel = varsIt.next();
					String name = vel
							.attributeValue("name");
					Utils.formatElement(vars, vel);
					String val = vel.getText();
					Field f = object.getClass()
							.getDeclaredField(name);
					method = object.getClass()
							.getMethod("set"
									+ Utils.toUpperCaseFirstOne(name),
									new Class[] { f.getType() });

					Object obj = null;
					if (f.getType().isAssignableFrom(
							Integer.TYPE)) {
						obj = Integer.parseInt(val);
					} else if (f.getType()
							.isAssignableFrom(
									Float.TYPE)) {
						obj = Float.parseFloat(val);
					} else {
						obj = val;
					}

					method.invoke(object,
							new Object[] { obj });
				}

				params.add(param);
				runParams.add(object);
			}
			Class[] classParams = new Class[params.size()];
			classParams = params.toArray(classParams);
			method = client.getClass().getMethod(function,
					classParams);

			Object ret = method.invoke(client, runParams.toArray());

			Element rel = (Element) el.selectSingleNode("ret");
			list = rel.selectNodes("val");
			for (Iterator<Element> retIt = list.iterator(); retIt
					.hasNext();) {

				Element rvel = retIt.next();

				Field f = ret.getClass().getDeclaredField(
						rvel.getText());
				method = ret.getClass()
						.getMethod("get"
								+ Utils.toUpperCaseFirstOne(rvel
										.getText()),
								new Class[] {});

				Object retObj = method.invoke(ret,
						new Object[] {});

				String retVal = String.valueOf(retObj);
				// vars.put(rel.attributeValue("name"), retVal);
				jo.addProperty(rvel.attributeValue("name"),
						retVal);
			}

			// System.out.println("ret = " + ret);

			transport.close();

		} catch (TTransportException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (TException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			if (e.getCause() instanceof FitsException) {
				FitsException ee = (FitsException) e
						.getTargetException();
				jo.addProperty("exceptionCode", ee.getCode());
				return jo;
			} else if (e.getCause() instanceof TTransportException) {
				return null;
			}
			e.printStackTrace();
		}
		return jo;
	}
}
