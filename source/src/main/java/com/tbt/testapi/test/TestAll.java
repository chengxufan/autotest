package com.tbt.testapi.test;

import org.dom4j.DocumentException;
import org.testng.annotations.Test;

import com.tbt.testapi.BaseCommand;
import com.tbt.testapi.TestApiException;
import com.tbt.testapi.command.CaseCommand;
import com.tbt.testapi.main.Config;

public class TestAll {
	@Test
	public void f() {
		Config.getInstance().envName = "test";
		BaseCommand command = new CaseCommand();
		try {
			command.run("getlist");
		} catch (TestApiException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("");
	}
}
