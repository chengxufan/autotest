package com.tbt.testapi.main;

import org.apache.log4j.PropertyConfigurator;
import org.dom4j.DocumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tbt.testapi.BaseCommand;
import com.tbt.testapi.Report;
import com.tbt.testapi.TestApiException;

public class App {
	private static final Logger logger = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		PropertyConfigurator.configure(Command.options.configPath
				+ "log4j.properties");
		try {
			new App().run(args);
		} catch (TestApiException e) {
			logger.debug("TestApiException", e);
			System.exit(1);
		}
	}

	public void run(String[] args) throws TestApiException {

		Config.init(Command.options.configPath + "autoapi.properties");
		Report.getInstance().init();
		new Command().parseOption(args);
		BaseCommand command = BaseCommand
				.createCommand(Command.options.type);

		try {
			command.run(Command.options.name);
		} catch (DocumentException e) {
			logger.debug("Unable to parse xml file", e);
		}

		Report.getInstance().print();
	}
}
