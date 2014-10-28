package com.tbt.testapi.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.dom4j.Element;

import com.tbt.testapi.BaseHelper;
import com.tbt.testapi.EnvConfig;
import com.tbt.testapi.TestApiException;
import com.tbt.testapi.exception.HelperException;

abstract public class BaseMysqlHelper extends BaseHelper {

	protected Connection conn;

	@Override
	public void init() throws TestApiException, HelperException {
		Element el = (Element) EnvConfig.getInstance().doc
				.selectSingleNode("//environment/item[@name='mysql']");

		if (el == null) {
			throw new HelperException(
					"MysqlExecuteHelper init environment config is null.");
		}

		String host = el.element("host").getText();
		String port = el.element("port").getText();
		String user = el.element("user").getText();
		String pass = el.element("pass").getText();
		String db = el.element("db").getText();

		try {
			conn = DriverManager.getConnection("jdbc:mysql://"
					+ host + "/" + db + "?" + "user="
					+ user + "&password=" + pass);
		} catch (SQLException e) {

			throw new HelperException(
					"MysqlExecuteHelper connect server error, check environment config.");
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			conn = null;
		}
	}
}
