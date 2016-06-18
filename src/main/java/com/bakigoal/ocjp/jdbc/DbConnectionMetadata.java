package com.bakigoal.ocjp.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

/**
 * Created by ilmir on 16.04.16.
 */
public class DbConnectionMetadata {
	public static void main(String[] args) throws SQLException {
		Connection connection = DbUtils.connect();
		DatabaseMetaData metaData = connection.getMetaData();
		System.out.println("Database: " + metaData.getDatabaseProductName() + " " +
				metaData.getDatabaseProductVersion());
		System.out.println("Driver: " + metaData.getDriverName() + metaData.
				getDriverVersion());
		System.out.println("URL: " + metaData.getURL());
		System.out.println("User name: " + metaData.getUserName());
		System.out.println("Maximum rows you can insert: " + metaData.
				getMaxRowSize());
	}
}
