package com.tbt.testapi.command;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.tbt.testapi.BaseCommand;
import com.tbt.testapi.TestApiException;
import com.tbt.testapi.main.Config;

public class GroupCommand extends BaseCommand {

	@Override
	public void run(String id) throws TestApiException, DocumentException {
		String filePath = Config.getInstance().caseDataPath + "group/"
				+ id + ".xml";

		if (!new File(filePath).exists())
			throw new TestApiException("group file not find.");

		SAXReader reader = new SAXReader();
		Document doc;

		doc = reader.read(filePath);
		List list = doc.selectNodes("//group/case");
		for (Iterator<Element> it = list.iterator(); it.hasNext();) {
			Element el = it.next();
			String caseId = el.attributeValue("id");
			BaseCommand command = new CaseCommand();

			command.run(caseId);

		}

	}
}
