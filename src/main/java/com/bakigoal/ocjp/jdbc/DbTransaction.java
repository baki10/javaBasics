package com.bakigoal.ocjp.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by ilmir on 17.04.16.
 */
public class DbTransaction {
	public static void main(String[] args) throws SQLException {
		new DbTransaction().run();
	}

	private void run() throws SQLException {
		Connection connection = DbUtils.connect();
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		try {
			// for commit/rollback we first need to set auto-commit to false
			connection.setAutoCommit(false);
			Statement statement = connection.createStatement
					(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			resultSet1 = statement.executeQuery("SELECT * FROM familyGroup");
			resultSet1.moveToInsertRow();
			resultSet1.updateString("nickName", "Sam Uncle");
			// updating here. . . but this change will be lost if a rollback happens
			resultSet1.insertRow();
			System.out.println("First table updated. . .");

			resultSet2 = statement.executeQuery("SELECT * FROM contact");
			resultSet2.moveToInsertRow();
			resultSet2.updateString("firstName", "Samuel");
//			 resultSet2.updateString("firstName","The great Samuel the billionaire from Washington DC");
			resultSet2.updateString("lastName", "Uncle");
			resultSet2.updateString("email", "sam@abc.com");
			resultSet2.updateString("phoneNo", "+119955331100");
			// updating here. . . but this change will be lost of a rollback happens
			resultSet2.insertRow();
			System.out.println("Both tables updated, committing now.");
			// we're committing the changes for both the tables only now
			connection.commit();
		}catch (SQLException e){
			System.out.println("Something gone wrong, couldn'thread add a contact in family group");
			connection.rollback();
			e.printStackTrace();
		}finally {
			if(connection != null) connection.close();
			if(resultSet1 != null) resultSet1.close();
			if(resultSet2 != null) resultSet2.close();
		}
	}
}
