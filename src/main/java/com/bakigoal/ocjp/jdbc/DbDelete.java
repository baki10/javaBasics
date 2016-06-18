package com.bakigoal.ocjp.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by ilmir on 16.04.16.
 */
public class DbDelete {
	public static void main(String[] args) {
		new DbDelete().run();
	}

	private void run() {
		try (Connection connection = DbUtils.connect();
		     Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		     ResultSet resultSet1 = statement.executeQuery("SELECT * FROM contact WHERE firstName='Ilmir'")) {

			if (resultSet1.next()) {
				// delete the first row
				resultSet1.deleteRow();
			}
			resultSet1.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		new DbQuery().printAll();
	}
}
