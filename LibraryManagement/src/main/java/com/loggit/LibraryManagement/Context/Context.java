package com.loggit.LibraryManagement.Context;

import java.sql.Connection;
import java.sql.DriverManager;

public class Context {
	private static Connection conn;
	private static String url;
	private static String username;
	private static String password;
	
	public static Connection getConnection() {
		conn = null;
		url = "jdbc:mysql://localhost:3306/librarymanagement";
		username = "root";
		password = "Long2001*";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
