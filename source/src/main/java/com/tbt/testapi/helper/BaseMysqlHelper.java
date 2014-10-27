package com.tbt.testapi.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Element;

import com.tbt.testapi.BaseHelper;
import com.tbt.testapi.EnvConfig;

abstract public class BaseMysqlHelper extends BaseHelper {

	protected Connection conn;

	@Override
	public void init() {
		Element el = (Element) EnvConfig.getInstance().doc
				.selectSingleNode("//environment/item[@name='mysql']");
		String host = el.element("host").getText();
	
		String port = el.element("port").getText();
		String user = el.element("user").getText();
		String pass = el.element("pass").getText();
		String db = el.element("db").getText();
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://" + host + "/"
					+ db + "?" + "user=" + user + "&password=" + pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
