package com.ndd.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class JDBCUtil {

	private static ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
	
	public static Connection getConnection() {	
		Connection conn = null;
		try {
			Class.forName(resourceBundle.getString("driver_name"));
			String url = resourceBundle.getString("url");
			String user = resourceBundle.getString("user");
			String password = resourceBundle.getString("password");
			
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void main(String[] args) {
		System.out.println(JDBCUtil.getConnection());
	}
}
