package com.bakigoal.ocjp.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by ilmir on 16.04.16.
 */
public class DbUpdate {
	public static void main(String[] args) {
		new DbUpdate().run();
	}

	private void run() {
		try (Connection connection = DbUtils.connect();
		     Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		     ResultSet resultSet = statement.executeQuery("SELECT * FROM contact WHERE firstName='Michael'")) {
			System.out.println("Before the update");
			DbUtils.printTable(resultSet);
			// now update the resultSet and display the modified data
			resultSet.absolute(1);
			resultSet.updateString("phoneNo", "+79093472279");
			resultSet.updateRow();
			System.out.println("After the update");
			resultSet.beforeFirst();
			DbUtils.printTable(resultSet);

		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}
}
