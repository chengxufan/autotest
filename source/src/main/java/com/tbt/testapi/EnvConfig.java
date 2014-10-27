package com.tbt.testapi;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import com.tbt.testapi.main.Config;

public class EnvConfig {
	private static EnvConfig instance = null;
	public Document doc = null;

	public static EnvConfig getInstance() {
		if (instance == null) {
			try {
				instance = new EnvConfig();
			} catch (TestApiException e) {
				e.printStackTrace();
			}
		}
		return instance;
	}

	private EnvConfig() throws TestApiException {
		String filePath = Config.getInstance().caseDataPath
				+ "environment/" + Config.getInstance().envName
				+ ".xml";
		if (!new File(filePath).exists())
			throw new TestApiException("environment file not find.");
		try {
			SAXReader reader = new SAXReader();
			doc = reader.read(filePath);

		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
}
