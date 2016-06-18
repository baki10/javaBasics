package com.bakigoal.ocjp.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbQuery {
	public static void main(String[] args) {
		new DbQuery().printAll();
	}

	public void printAll() {
		try (Connection connection = DbUtils.connect();
		     Statement statement = connection.createStatement();
		     ResultSet resultSet = statement.executeQuery("SELECT * FROM contact")) {

			DbUtils.printTable(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}
}
