package com.thanh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static String url = "jdbc:mysql://localhost:3306/";
	private static String dBName = "elibrary";
	private static String user = "root";
	private static String password = "tuanthanh98";
	
	public static Connection getConnectionToDB() {
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.jdbc.driver");
			System.out.println("JDBC Driver registered successfully!!!");
			connection = DriverManager.getConnection(url + dBName, user, password);
			System.out.println("Connect to the database successfully!!!");
		} catch (ClassNotFoundException e) {
			System.out.println("Cannot find JDBC Driver");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Failed to connect to the database, please try again!!!");
			e.printStackTrace();
		}
		
		return connection;
	}
}
