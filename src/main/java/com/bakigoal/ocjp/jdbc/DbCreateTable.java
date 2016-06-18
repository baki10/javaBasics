package com.bakigoal.ocjp.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by ilmir on 16.04.16.
 */
public class DbCreateTable {
	public static void main(String[] args) {
		new DbCreateTable().create();
	}

	private void create() {
		try (Connection connection = DbUtils.connect();
		     Statement statement = connection.createStatement()) {
			// use CREATE TABLE SQL statement to create table familyGroup
			int result = statement.executeUpdate(
					"CREATE TABLE familyGroup (id serial not null, nickName varchar(30) not null, primary key(id));");
			System.out.println("Table created successfully");
		}catch (SQLException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}
}
