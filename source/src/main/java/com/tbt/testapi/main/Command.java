package com.tbt.testapi.main;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.tbt.testapi.TestApiException;
import com.tbt.testapi.utils.Utils;

public class Command {
	public static Options options = new Options();

	public boolean parseOption(String[] args) throws TestApiException {
		if (args.length < 1) {
			throw new TestApiException("Invalid params.");
		}
		List<String> argList = Arrays.asList(args);
		Iterator<String> it = argList.iterator();
		while (it.hasNext()) {
			String opt = it.next();
			if (opt.equals("-type")) {
				options.type = it.next();
				if (Utils.stringEmpty(options.type)) {
					throw new TestApiException(
							"args -type is null.");
				}
			} else if (opt.equals("-name")) {
				options.name = it.next();
				if (Utils.stringEmpty(options.type)) {
					throw new TestApiException(
							"args -name is null.");
				}
			} else if (opt.equals("-configPath")) {
				options.configPath = it.next();
				if (Utils.stringEmpty(options.type)) {
					throw new TestApiException(
							"args -configPath is null.");
				}
			} else if (opt.equals("-debug")) {
				options.debug = true;
				it.next();
			}
		}
		return true;
	}
}
