package com.tbt.testapi.main;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Command {
	public static Options options = new Options();

	public boolean parseOption(String[] args) {
		List<String> argList = Arrays.asList(args);
		Iterator<String> it = argList.iterator();
		while (it.hasNext()) {
			String opt = it.next();
			if (opt.equals("-type")) {
				options.type = it.next();
			} else if (opt.equals("-name")) {
				options.name = it.next();
			} else if (opt.equals("-configPath")) {
				options.configPath = it.next();
			}
		}
		return true;
	}
}
