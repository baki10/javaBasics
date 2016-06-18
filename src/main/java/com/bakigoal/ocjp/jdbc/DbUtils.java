package com.bakigoal.ocjp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * create database addressBook;
 * create table contact (id serial not null, firstName varchar(30) Not null, lastName varchar(30), email varchar(30), phoneNo varchar(13), primary key (id));
 * insert into contact values (default, 'Michael', 'Taylor', 'michael@abc.com','+919876543210');
 * insert into contact values (default, 'William', 'Becker', 'william@abc.com','+449876543210');
 */
public class DbUtils {
	private static final String URL = "jdbc:postgresql://localhost:5432/";
	private static final String DATABASE = "addressBook";
	private static final String USER_NAME = "postgres";
	private static final String PASSWORD = "postgres";

	public static void main(String[] args) {
		try (Connection connection = DbUtils.connect()) {
			System.out.println("Database connection: Successful");
		} catch (Exception e) {
			System.out.println("Database connection: Failed");
			e.printStackTrace();
		}
	}

	public static Connection connect() throws SQLException {
		//in JDBC 4.0 and later, there is no need to explicitly load the driver as the JDBC API will
		//automatically load the driver when you call connect()
		return DriverManager.getConnection(URL + DATABASE, USER_NAME, PASSWORD);
	}

	public static void printTable(ResultSet resultSet) throws SQLException {
		printHeader(resultSet);
		printContent(resultSet);
	}

	public static void printContent(ResultSet resultSet) throws SQLException {
		while (resultSet.next()) {
			printRow(resultSet);
		}
	}

	public static void printHeader(ResultSet resultSet) throws SQLException {
		int numOfColumns = resultSet.getMetaData().getColumnCount();
		for (int i = 1; i <= numOfColumns; i++) {
			System.out.printf("%-20s ", resultSet.getMetaData().getColumnName(i));
		}
		System.out.println();
	}

	public static void printRow(ResultSet resultSet) throws SQLException {
		int numOfColumns = resultSet.getMetaData().getColumnCount();
		// remember that the column index starts from 1 not 0
		for (int i = 1; i <= numOfColumns; i++) {
			// since we do not know the data type of the column, we use getObject()
			System.out.printf("%-20s ", resultSet.getObject(i));
		}
		System.out.println();
	}

	public static void printRow1(ResultSet resultSet) throws SQLException {
		System.out.println(resultSet.getInt("id") + "\t"
				+ resultSet.getString("firstName") + "\t"
				+ resultSet.getString("lastName") + "\t"
				+ resultSet.getString("email") + "\t"
				+ resultSet.getString("phoneNo"));
	}

	public static void printRow2(ResultSet resultSet) throws SQLException {
		System.out.println(resultSet.getInt(1) + "\t"
				+ resultSet.getString(2) + "\t"
				+ resultSet.getString(3) + "\t"
				+ resultSet.getString(4) + "\t"
				+ resultSet.getString(5));
	}



}
