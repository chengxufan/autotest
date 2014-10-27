package com.tbt.testapi.helper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import org.dom4j.Document;
import org.dom4j.Element;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mysql.jdbc.ResultSetMetaData;

public class MysqlExecuteHelper extends BaseMysqlHelper {
	ResultSet rs;

	@Override
	public JsonObject run(Document doc, HashMap<String, String> vars) {
		JsonObject jo = new JsonObject();
		try {
			Statement stmt = conn.createStatement();
			Element sql = (Element) doc
					.selectSingleNode("/root/item[@name='sql']");
			String statement = sql.attributeValue("statement");
			if (statement == null
					|| statement.toString()
							.equals("select")) {
				ResultSet rs = stmt.executeQuery(sql.getText());
				ResultSetMetaData rsmd = (ResultSetMetaData) rs
						.getMetaData();
				int cols = rsmd.getColumnCount();
				JsonElement je = null;
				while (rs.next()) {
					for (int i = 1; i <= cols; i++) {
						String cname = rsmd
								.getColumnLabel(i);
						if (rsmd.getColumnType(i) == java.sql.Types.BIGINT) {
							jo.addProperty(cname,
									rs.getInt(i));
						} else if (rsmd.getColumnType(i) == java.sql.Types.BOOLEAN) {
							jo.addProperty(cname,
									rs.getBoolean(i));
						} else if (rsmd.getColumnType(i) == java.sql.Types.DOUBLE) {
							jo.addProperty(cname,
									rs.getDouble(i));
						} else if (rsmd.getColumnType(i) == java.sql.Types.INTEGER) {
							jo.addProperty(cname,
									rs.getInt(i));
						} else {
							jo.addProperty(cname,
									rs.getString(i));
						}
					}
				}
			} else if (statement.toString().equals("update")
					|| statement.toString()
							.equals("delete")) {
				int rs = stmt.executeUpdate(sql.getText());
				jo.addProperty("rows", rs);
			} else if (statement.toString().equals("insert")) {
				int rs = stmt.executeUpdate(sql.getText());
				if (rs != 0) {
					ResultSet insertRs = stmt
							.executeQuery("SELECT LAST_INSERT_ID()");
					if (insertRs.next()) {
						long lastId = insertRs
								.getLong("last_insert_id()");
						jo.addProperty("id", lastId);
					}
				}
			}
			// System.out.println(jo);
		} catch (SQLException e) {
			return null;
		}
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				rs = null;
			}
		}
		return jo;
	}

}
