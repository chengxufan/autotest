package com.tbt.testapi;

public class Assert {
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
