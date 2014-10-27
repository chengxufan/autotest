package com.tbt.testapi.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Config {

	public String caseDataPath = null;
	public String reportPath = null;
	public String envName = null;
	public String apiKey = null;

	private static Config instance = null;

	public Config(String configPath) {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(configPath));
			envName = prop.getProperty("ENV_NAME");
			caseDataPath = prop.getProperty("CASEDATA_PATH");
			reportPath = prop.getProperty("REPORT_PATH");
			apiKey = prop.getProperty("API_KEY");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Config init(String configPath) {
		if (instance == null) {
			instance = new Config(configPath);
		}
		return instance;
	}

	public static Config getInstance() {
		return instance;
	}
}
