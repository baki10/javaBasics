package com.bakigoal.ocjp.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by ilmir on 16.04.16.
 */
public class DbInsert {
	public static void main(String[] args) {
		new DbInsert().run();
	}

	private void run() {
		try (Connection connection = DbUtils.connect();
		     Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		     ResultSet resultSet = statement.executeQuery("SELECT * FROM contact")) {
			System.out.println("Before the insert");
			DbUtils.printTable(resultSet);

			resultSet.moveToInsertRow();
			resultSet.updateString("firstName", "Ilmir");
			resultSet.updateString("lastName", "Baki");
			resultSet.updateString("email", "ilmir@baki.com");
			resultSet.updateString("phoneNo", "+79753186420");
			resultSet.insertRow();

			System.out.println("After the insert");
			resultSet.beforeFirst();
			DbUtils.printTable(resultSet);

		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}
}
