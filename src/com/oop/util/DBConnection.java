package com.oop.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private static Connection conn;
	
	public static Connection getConnection() {
		if(conn==null){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/OVRS","root","1234");
		} catch (SQLException | ClassNotFoundException e){
			e.printStackTrace();
		}
	}	
		return conn;
	}
}
