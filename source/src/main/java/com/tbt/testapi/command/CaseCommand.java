package com.tbt.testapi.command;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.google.gson.JsonObject;
import com.tbt.testapi.Assert;
import com.tbt.testapi.BaseCommand;
import com.tbt.testapi.BaseHelper;
import com.tbt.testapi.Report;
import com.tbt.testapi.TestApiException;
import com.tbt.testapi.main.Config;
import com.tbt.testapi.utils.Utils;

public class CaseCommand extends BaseCommand {
	HashMap<String, String> vars;
	public String caseId = null;

	@Override
	public void run(String id) {
		boolean ret = false;
		try {
			caseId = id;
			vars = new HashMap<String, String>();
			String filePath = Config.getInstance().caseDataPath
					+ "cases/" + id + ".xml";
			if (!new File(filePath).exists())
				throw new TestApiException("case file " + id
						+ " not find.");

			SAXReader reader = new SAXReader();
			Document doc = reader.read(filePath);

			List list = doc.selectNodes("//case/context/item");
			for (Iterator<Element> it = list.iterator(); it
					.hasNext();) {
				Element el = it.next();
				String name = el.attributeValue("name");
				String value = el.getText();
				vars.put(name, value);
			}

			list = doc.selectNodes("//case/step");
			for (Iterator<Element> it = list.iterator(); it
					.hasNext();) {
				Element el = it.next();
				String note = el.attributeValue("note");
				ret = step(el);
				if (ret == false)
					break;
			}

		} catch (DocumentException e) {
			Utils.debugLog("case parse error, " + e.getMessage());
			ret = false;
		} catch (TestApiException e) {
			Utils.debugLog("case error, " + e.getMessage());
			ret = false;
		} finally {
			Report.getInstance().add(caseId, ret);
		}
	}

	public boolean step(Element step) throws TestApiException {
		Element el;
		Element hel = step.element("helper");
		String helperNamespace = hel.attributeValue("name");
		HashMap<String, String> helperParams = new HashMap<String, String>();

		Document caseXml = DocumentHelper.createDocument();
		Element root = caseXml.addElement("root");

		for (Iterator<Element> it = hel.elementIterator("item"); it
				.hasNext();) {
			Element item = it.next();
			if (item.elements().size() != 0) {
				for (Iterator<Element> itt = item
						.elementIterator(); itt
						.hasNext();) {
					Element iit = itt.next();
					Utils.formatElement(vars, iit);
				}
			} else {
				Utils.formatElement(vars, item);
			}
			root.add((Element) item.clone());
		}

		JsonObject jo = BaseHelper.execute(helperNamespace, caseXml,
				vars);
		try {
			if (jo == null)
				return false;
			if (jo.toString().equals("{}"))
				jo = new JsonObject();
			el = step.element("return");
			if (el != null) {
				for (Iterator<Element> it = el
						.elementIterator("item"); it
						.hasNext();) {
					Element item = it.next();
					String key = item
							.attributeValue("name");
					String jName = item.getText();
					String[] jNameArray = jName
							.split("\\.");
					JsonObject data = new JsonObject();
					for (int i = 0; i < jNameArray.length; i++) {
						if (i == 0) {

							if (jNameArray.length == 1)
								vars.put(key,
										jo.get(jName)
												.getAsString());
							else if (jNameArray.length == 2) {
								data = (JsonObject) jo
										.get(jNameArray[i]);
							}
						} else if (i == 1) {
							vars.put(key,
									data.get(jNameArray[i])
											.getAsString());
						}
					}
				}
			}
			el = step.element("assert");
			if (el != null) {
				for (Iterator<Element> it = el
						.elementIterator("item"); it
						.hasNext();) {

					Element item = it.next();
					String name = item
							.attributeValue("name");
					String message = vars.get(item
							.attributeValue("var"));
					String param = item
							.attributeValue("param");
					boolean ret = Assert.run(name, message,
							param);
					if (ret == false) {
						return false;
					}
				}
			}
		} catch (ClassCastException e) {
			throw new TestApiException(
					"json response parse error, "
							+ e.getMessage()
							+ "json:" + jo);
		}
		return true;
	}
}
