package com.tbt.testapi.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tbt.testapi.main.Command;

public class Utils {
	private static final Logger logger = LoggerFactory
			.getLogger(Utils.class);

	public static Element formatElement(HashMap<String, String> vars,
			Element item) {
		String name = item.attributeValue("name");
		String value = item.getText();
		String format = item.attributeValue("format");
		if (format != null) {
			String[] split = format.split(",");
			List<String> values = new ArrayList<String>();
			for (int i = 0; i < split.length; i++) {
				String key = split[i];
				String val = vars.get(key);
				if (val != null) {
					values.add(val);
				}
			}
			value = String.format(value, values.toArray());
			item.setText(value);
		}
		return item;
	}

	public static String toUpperCaseFirstOne(String s)

	{

		if (Character.isUpperCase(s.charAt(0)))

			return s;

		else

			return (new StringBuilder())
					.append(Character.toUpperCase(s
							.charAt(0)))
					.append(s.substring(1)).toString();

	}

	public static void debugLog(String message) {
		if (Command.options.debug == true) {
			System.out.println(message);
		}
	}

	public static boolean stringEmpty(String str) {
		if (str == null || str.length() == 0) {
			return true;
		}
		return false;
	}

}
