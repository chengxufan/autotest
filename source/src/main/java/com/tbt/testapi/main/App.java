package com.tbt.testapi.main;

import com.tbt.testapi.BaseCommand;
import com.tbt.testapi.Report;
import com.tbt.testapi.TestApiException;

public class App {
	public static void main(String[] args) {

		try {
			new App().run(args);
		} catch (TestApiException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}

	public void run(String[] args) throws TestApiException {
		Config.init(Command.options.configPath + "autoapi.properties");
		Report.getInstance().init();
		new Command().parseOption(args);
		BaseCommand command = BaseCommand
				.createCommand(Command.options.type);
		command.run(Command.options.name);
		Report.getInstance().print();
	}
}
