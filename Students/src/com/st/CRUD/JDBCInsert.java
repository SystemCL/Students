package com.st.CRUD;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.st.connection.ConnectionDB;

public class JDBCInsert extends ConnectionDB {
	
	public static void main(String[] args) throws SQLException {
		insertToCoursesTable();
		insertToStudentsTable();
	}
	
	
	

	private static void insertToStudentsTable() throws SQLException {
		Connection dbConnection = null;
		Statement statement = null;
		
		String insertTableSQL = "INSERT INTO STUDENTS"
			 + " VALUES" +"(3, 'Tiron Maxim', 22);";
		
		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
		
			System.out.println(insertTableSQL);
		    statement.executeUpdate(insertTableSQL);
			System.out.println("Record is inserted into COURSES table!");
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if(statement != null){
				statement.close();
			}
			if(dbConnection != null){
				dbConnection.close();
			}
			
		}
		
	}



	private static void insertToCoursesTable() throws SQLException {
		Connection dbConnection = null;
		Statement statement = null;
		
		String insertTableSQL = "INSERT INTO COURSES"
			 + " VALUES" +"(3, 'Matematica Discreta', 'Vasilache Constantin');";
		
		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
		
			System.out.println(insertTableSQL);
		    statement.executeUpdate(insertTableSQL);
			System.out.println("Record is inserted into COURSES table!");
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if(statement != null){
				statement.close();
			}
			if(dbConnection != null){
				dbConnection.close();
			}
			
		}
		
	}

}
