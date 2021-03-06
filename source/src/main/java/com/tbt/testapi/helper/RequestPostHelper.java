package com.tbt.testapi.helper;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.Element;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.tbt.testapi.BaseHelper;
import com.tbt.testapi.EnvConfig;
import com.tbt.testapi.TestApiException;
import com.tbt.testapi.exception.HelperException;
import com.tbt.testapi.main.Config;
import com.tbt.testapi.utils.Utils;

public class RequestPostHelper extends BaseHelper {
	public String rootUrl;

	@Override
	public void init() throws HelperException {
		Element el = (Element) EnvConfig.getInstance().doc
				.selectSingleNode("//environment/item[@name='request']");

		if (el == null) {
			throw new HelperException(
					"RequestPostHelper init environment config is null.");
		}

		rootUrl = el.element("url").getText();

		if (Utils.stringEmpty(rootUrl)) {
			throw new HelperException(
					"RequestPostHelper init environment config parse error.");
		}
	}

	@Override
	public void destroy() {

	}

	public String makeToken(String params) {

		String signString = Config.getInstance().apiKey + params;
		// System.out.println(signString);
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(signString.getBytes());
			StringBuffer sb = new StringBuffer();
			for (byte b : md.digest()) {
				sb.append(String.format("%02x", b & 0xff));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	@Override
	public JsonObject run(Document doc, HashMap<String, Object> vars)
			throws TestApiException, HelperException {
		Element uri = (Element) doc
				.selectSingleNode("/root/item[@name='uri']");
		Element params = (Element) doc
				.selectSingleNode("/root/item[@name='params']");
		String isList = uri.attributeValue("is_list");
		String strUrl = rootUrl + uri.getText();

		StringBuffer sb = new StringBuffer();
		String comma = "";

		if (params != null) {
			for (Iterator<Element> it = params.elementIterator(); it
					.hasNext();) {
				Element item = it.next();
				sb.append(comma);
				comma = "&";
				try {
					sb.append(URLEncoder.encode(
							item.attributeValue("name"),
							"UTF-8"));
				} catch (UnsupportedEncodingException e1) {
					e1.printStackTrace();
				}
				sb.append("=");
				try {
					sb.append(URLEncoder.encode(
							item.getText(), "UTF-8"));

				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			sb.append("&");
		}

		String paramsString = sb.toString();

		sb.append("sign=");
		sb.append(makeToken(paramsString));
		paramsString = sb.toString();

		URL url;
		try {
			url = new URL(strUrl);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setInstanceFollowRedirects(false);
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			connection.setRequestProperty("charset", "utf-8");
			connection.setRequestProperty(
					"Content-Length",
					""
							+ Integer.toString(paramsString
									.length()));
			connection.setUseCaches(false);
			connection.connect();
			DataOutputStream wr = new DataOutputStream(
					connection.getOutputStream());
			wr.writeBytes(paramsString);
			wr.flush();
			wr.close();
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(connection
							.getInputStream()));
			String line;
			StringBuffer inb = new StringBuffer();
			while ((line = reader.readLine()) != null) {
				inb.append(line);
			}
			connection.disconnect();
			JsonParser jp = new JsonParser();
			JsonObject jo = (JsonObject) jp.parse(inb.toString());

			if (isList != null) {
				JsonArray listData = jo.getAsJsonArray("data");
				JsonObject countData = new JsonObject();
				countData.addProperty("list_number", Integer
						.toString(listData.size()));
				jo.remove("data");
				jo.add("data", countData);
			}
			return jo;
		} catch (MalformedURLException e) {
			throw new HelperException(
					"Unable to request api server");
		} catch (IOException e) {
			throw new HelperException(
					"Unable to request read or write");
		}

	}

}
