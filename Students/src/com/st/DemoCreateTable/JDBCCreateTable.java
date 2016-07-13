package com.st.DemoCreateTable;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.st.connection.ConnectionDB;

public class JDBCCreateTable extends ConnectionDB {

	public static void main(String[] args) {
		try {
			createDbCourseTable();
			createDbStudentsTable();
			createDbAddressTable();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}



	private static void createDbStudentsTable() throws SQLException {
		Connection dbConnection = null;
		Statement statement = null;

		String createTableSQL = "CREATE TABLE STUDENTS(" + "idStudent INT(11) AUTO_INCREMENT NOT NULL,"
				+ "firstName VARCHAR(30) NOT NULL," + "age INT," + "PRIMARY KEY (idStudent));";
		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();

			System.out.println(createTableSQL);
			statement.execute(createTableSQL);

			System.out.println("Table STUDENTS is created!");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (statement != null) {
				statement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}
		}
		
	}

	private static void createDbCourseTable() throws SQLException {
		Connection dbConnection = null;
		Statement statement = null;

		String createTableSQL = "CREATE TABLE COURSES(" + "idCourse INT(11) AUTO_INCREMENT NOT NULL,"
				+ "nomCourse VARCHAR(30) NOT NULL," + "nomProf VARCHAR(50)," + "PRIMARY KEY (idCourse));";
		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();

			System.out.println(createTableSQL);
			statement.execute(createTableSQL);

			System.out.println("Table COURSES is created!");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (statement != null) {
				statement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}
		}

	}
	
	private static void createDbAddressTable() throws SQLException {
		Connection dbConnection = null;
		Statement statement = null;

		String createTableSQL = "CREATE TABLE ADDRESS(" + "idAddress INT(11) AUTO_INCREMENT NOT NULL,"
				+ "address VARCHAR(30) NOT NULL," + "nrTelephone VARCHAR(50)," + "PRIMARY KEY (idAddress));";
		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();

			System.out.println(createTableSQL);
			statement.execute(createTableSQL);

			System.out.println("Table ADDRESS is created!");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (statement != null) {
				statement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}
		}
		
	}
	
	
	
	



}
