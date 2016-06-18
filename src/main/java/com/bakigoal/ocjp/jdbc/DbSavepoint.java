package com.bakigoal.ocjp.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

/**
 * Created by ilmir on 17.04.16.
 */
public class DbSavepoint {
	public static void main(String[] args) throws SQLException {
		new DbSavepoint().run();
	}

	private void run() throws SQLException {
		Connection connection = DbUtils.connect();
		ResultSet resultSet = null;
		try {
			// for commit/rollback we first need to set auto-commit to false
			connection.setAutoCommit(false);
			Statement statement = connection.createStatement
					(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			resultSet = statement.executeQuery("SELECT * FROM familyGroup");

			System.out.println("Printing the contents of the table before inserting");
			DbUtils.printTable(resultSet);

			System.out.println("Starting to insert rows");
			// first insert
			resultSet.moveToInsertRow();
			resultSet.updateString("nickName", "Tom");
			resultSet.insertRow();
			System.out.println("Inserted row for Tom");
			// our first savepoint is here. . .
			Savepoint firstSavepoint = connection.setSavepoint();

			// second insert
			resultSet.moveToInsertRow();
			resultSet.updateString("nickName", "Dick");
			resultSet.insertRow();
			System.out.println("Inserted row for Dick");
			// our second savepoint is here. . . after we inserted Dick
			// we can give a string name for savepoint
			Savepoint secondSavepoint = connection.setSavepoint("SavepointForDick");
			// third insert
			resultSet.moveToInsertRow();
			resultSet.updateString("nickName", "Harry");
			resultSet.insertRow();
			System.out.println("Inserted row for Harry");
			// our thrid savepoint is here. . . for "Harry"
			Savepoint thirdSavepoint = connection.setSavepoint("ForHarry");
			System.out.println("Table updation complete. . .");

			// rollback to the state when Dick was inserted;
			// so the insert for Harry will be lost
			System.out.println("Rolling back to the state where Tom and Dick were inserted");
			connection.rollback(secondSavepoint);
			// commit the changes now and see what happens to the contents of the table
			connection.commit();
			System.out.println("Printing the contents of the table after commit");
			resultSet = statement.executeQuery("SELECT * FROM familyGroup");
			DbUtils.printTable(resultSet);

		}catch (SQLException e){
			System.out.println("Something gone wrong, couldn'thread add a contact in family group");
			connection.rollback();
			e.printStackTrace();
		}finally {
			if(connection != null) connection.close();
			if(resultSet != null) resultSet.close();
		}
	}
}
