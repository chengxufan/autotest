package com.tbt.testapi;

import org.dom4j.DocumentException;

import com.tbt.testapi.command.CaseCommand;
import com.tbt.testapi.command.GroupCommand;
import com.tbt.testapi.command.TaskCommand;

public abstract class BaseCommand {
	public abstract void run(String id) throws TestApiException,
			DocumentException;

	static public BaseCommand createCommand(String commandName) {
		if (commandName.equals("task")) {
			return new TaskCommand();
		} else if (commandName.equals("group")) {
			return new GroupCommand();
		} else {
			return new CaseCommand();
		}
	}
}
