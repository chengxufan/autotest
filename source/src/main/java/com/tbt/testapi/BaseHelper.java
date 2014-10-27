package com.tbt.testapi;

import java.util.HashMap;

import org.dom4j.Document;

import com.google.gson.JsonObject;

abstract public class BaseHelper {
	abstract public void init() throws TestApiException;

	abstract public void destroy();

	static public JsonObject execute(String namespace, Document doc,
			HashMap<String, String> vars) throws TestApiException {
		BaseHelper base = createHelper(namespace);
		base.init();
		JsonObject jo = base.run(doc, vars);
		base.destroy();
		return jo;
	}

	abstract public JsonObject run(Document doc,
			HashMap<String, String> vars) throws TestApiException;

	static public BaseHelper createHelper(String namespace) {
		String helperNamespace = namespace.substring(7);
		String[] split = helperNamespace.split("\\.");
		String className = null;
		StringBuffer sb = new StringBuffer();
		sb.append("com.tbt.testapi.helper.");
		for (String str : split) {
			String tmp = str.replaceFirst(str.substring(0, 1), str
					.substring(0, 1).toUpperCase());
			sb.append(tmp);
		}
		sb.append("Helper");
		className = sb.toString();

		try {
			Class c = Class.forName(className);
			BaseHelper base = (BaseHelper) c.newInstance();
			return base;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
}
