package com.tbt.testapi.helper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import org.dom4j.Document;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mysql.jdbc.ResultSetMetaData;
import com.tbt.testapi.TestApiException;
import com.tbt.testapi.exception.HelperException;

public class MysqlExecuteHelper extends BaseMysqlHelper {
	private static final Logger logger = LoggerFactory
			.getLogger(MysqlExecuteHelper.class);

	ResultSet rs;

	@Override
	public JsonObject run(Document doc, HashMap<String, Object> vars)
			throws TestApiException, HelperException {
		JsonObject jo = new JsonObject();
		try {

			Statement stmt = conn.createStatement();
			Element sql = (Element) doc
					.selectSingleNode("/root/item[@name='sql']");

			if (sql == null) {
				throw new HelperException(
						"MysqlExecuteHelper sql is null.");
			}

			String statement = sql.attributeValue("statement");

			if (statement == null
					|| statement.toString()
							.equals("select")) {
				logger.debug("sql " + sql.getText());
				ResultSet rs = stmt.executeQuery(sql.getText());

				ResultSetMetaData rsmd = (ResultSetMetaData) rs
						.getMetaData();
				int cols = rsmd.getColumnCount();
				JsonElement je = null;
				while (rs.next()) {
					for (int i = 1; i <= cols; i++) {
						logger.debug("rs "
								+ rs.getString(i));
						String cname = rsmd
								.getColumnLabel(i);
						int type = rsmd.getColumnType(i);
						if (type == java.sql.Types.BIGINT
								|| type == java.sql.Types.SMALLINT
								|| type == java.sql.Types.INTEGER) {
							jo.addProperty(cname,
									rs.getInt(i));
						} else if (rsmd.getColumnType(i) == java.sql.Types.BOOLEAN) {
							jo.addProperty(cname,
									rs.getBoolean(i));
						} else if (rsmd.getColumnType(i) == java.sql.Types.DOUBLE) {
							jo.addProperty(cname,
									rs.getDouble(i));
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

		} catch (SQLException e) {
			throw new HelperException("db error:" + e.getMessage());
		}

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				rs = null;
			}
		}

		logger.info("mysql helper response " + jo);

		return jo;
	}
}
