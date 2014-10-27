package com.tbt.testapi.main;

import com.tbt.testapi.BaseCommand;
import com.tbt.testapi.Report;
import com.tbt.testapi.TestApiException;

public class App {
	public static void main(String[] args) {
		Config.init(Command.options.configPath + "autoapi.properties");
		Report.getInstance().init();
		new Command().parseOption(args);
		BaseCommand command = BaseCommand
				.createCommand(Command.options.type);

		try {
			command.run(Command.options.name);
			Report.getInstance().print();
		} catch (TestApiException e) {
			e.printStackTrace();
		}
	}
}
