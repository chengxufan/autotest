package com.tbt.testapi.main;

import com.tbt.testapi.Report;
import com.tbt.testapi.TestApiException;
import com.tbt.testapi.command.CaseCommand;

public class AutoApi {
	public static void main(String[] args) {
		try {
			Config.init(Command.options.configPath
					+ "autoapi.properties");

			CaseCommand command = new CaseCommand();

			command.run("login");
			Report.getInstance().print();
		} catch (TestApiException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}
}
