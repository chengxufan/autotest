package com.tbt.testapi.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.tbt.testapi.TestApiException;

public class Config {

	public String caseDataPath = null;
	public String reportPath = null;
	public String envName = null;
	public String apiKey = null;

	private static Config instance = null;

	public Config(String configPath) throws TestApiException {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(configPath));
			envName = prop.getProperty("ENV_NAME");
			caseDataPath = prop.getProperty("CASEDATA_PATH");
			reportPath = prop.getProperty("REPORT_PATH");
			apiKey = prop.getProperty("API_KEY");
		} catch (FileNotFoundException e) {
			throw new TestApiException(
					"Invalid config file autotest.properties.");
		} catch (IOException e) {
			throw new TestApiException(
					"Unable to read config file autotest.properties.");
		}
	}

	public static Config init(String configPath) throws TestApiException {
		if (instance == null) {
			instance = new Config(configPath);
		}
		return instance;
	}

	public static Config getInstance() {
		return instance;
	}
}
