package com.tbt.testapi.main;

import com.tbt.testapi.Report;
import com.tbt.testapi.TestApiException;
import com.tbt.testapi.command.TaskCommand;

public class AutoApi {
	public static void main(String[] args) {
		Config.init(Command.options.configPath + "autoapi.properties");
		TaskCommand command = new TaskCommand();
		try {
			command.run("core");
			Report.getInstance().print();
		} catch (TestApiException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
