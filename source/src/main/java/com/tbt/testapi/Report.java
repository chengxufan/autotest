package com.tbt.testapi;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.tbt.testapi.main.Config;

public class Report {

	static public Report instance = new Report();

	static public Report getInstance() {
		return instance;
	}

	List<String> failures = new ArrayList<String>();
	int runs = 0;

	public void init() {
		System.out.println("");
		failures.clear();
		runs = 0;
	}

	public void add(String caseName, boolean ret) {
		runs++;
		if (ret == false) {
			failures.add(caseName);
		}
		if (ret == false)
			System.out.print("x");
		else
			System.out.print(".");
	}

	public void print() throws TestApiException {
		StringBuffer sb = new StringBuffer();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String time = df.format(new Date());

		System.out.println("");

		String output = time + "\n";
		System.out.print(output);
		sb.append(output);

		output = "================================\n";
		System.out.print(output);
		sb.append(output);

		output = String.format("Tests run: %d, Failures: %d\n", runs,
				failures.size());
		System.out.print(output);
		sb.append(output);

		output = "Failure List:\n";
		System.out.print(output);
		sb.append(output);

		for (Iterator<String> it = failures.iterator(); it.hasNext();) {
			String caseName = it.next();
			output = caseName + "\n";
			System.out.print(output);
			sb.append(output);
		}

		df = new SimpleDateFormat("yyyy-MM-dd-HH-mm");
		String filename = df.format(new Date());

		String report = sb.toString();
		File file = new File(Config.getInstance().reportPath
				+ "autotest-report-" + filename + ".txt");
		if (!file.exists()) {
			try {
				file.createNewFile();

				FileWriter fw = new FileWriter(
						file.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(report);
				bw.close();

			} catch (IOException e) {
				throw new TestApiException(
						"Unable to write report file.");
			}
		}
	}
}
