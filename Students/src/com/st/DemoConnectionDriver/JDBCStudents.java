package com.st.DemoConnectionDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCStudents {

	public static void main(String[] args) {

		System.out.println("----------MySQL JDBC Connection Testing---------");
		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("J'ai pas trouve le driver MySQL JDBC");
		    e.printStackTrace();
		    return;
		}
		
		System.out.println("MySQL JDBC Driver est registre!");
		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsdb", "root","");
			
		} catch (SQLException e) {
			System.out.println("La connection de marche pas!");
			e.printStackTrace();
			return;
			
		}
		
		if (connection != null) {
			System.out.println("Ca marche bien. Maintenant tu as le control sur BD");
		}
		else
		{
			System.out.println("Qqch ne marche pas avec la connexion!");
		}
		

	}

}
