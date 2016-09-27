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

    DatabaseMetaData dbMetaData = connection.getMetaData();

    System.out.println("DB: " + dbMetaData.getDatabaseProductName() + ", " + dbMetaData.getDatabaseProductVersion());

    System.out.println("Driver: " + dbMetaData.getDriverName() + ", " + dbMetaData.getDriverVersion());

    System.out.println("URL: " + dbMetaData.getURL());

    System.out.println("User name: " + dbMetaData.getUserName());

    System.out.println("Maximum rows you can insert: " + dbMetaData.getMaxRowSize());
  }
}
