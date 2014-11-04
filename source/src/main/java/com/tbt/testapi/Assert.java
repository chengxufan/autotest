package com.tbt.testapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Assert {
	private static final Logger logger = LoggerFactory
			.getLogger(Assert.class);

	static public boolean run(String name, String message, String param) {

		if (name == null)
			return false;
		if (name.equals("equals")) {
			return equals(message, param);
		} else if (name.equals("notnull")) {
			return notNull(message);
		} else if (name.equals("than")) {
			return than(message, param);
		}
		return false;
	}

	static protected boolean equals(String message, String expected) {
		return (message.equals(expected));
	}

	static protected boolean notEquals(String message, String expected) {
		return !(message.equals(expected));
	}

	static protected boolean notNull(String message) {

		if (message == null)
			return false;
		if (message == "")
			return false;
		if (message.length() == 0)
			return false;

		return true;
	}

	static protected boolean than(String message, String expected) {
		return Integer.parseInt(message) > Integer.parseInt(expected);
	}
}
