package com.creditCardCreation.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbConnection {
	
	protected Connection con;
	
	public dbConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root","");
		if(conn!=null) System.out.println("DB connection: success");
		else System.out.println("DB connection: failure");
		con= conn;
	}
	
	/*private Connection connectDB() throws Exception {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
		return con;
	}
	
	public void startDB() throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = connectDB();
		if (con == null) {
			System.out.println("JDBC connection not established.");
			return;
		} else {
			System.out.println("JDBC connection established successfully.");
		}
		
	}
	*/
	public void close() throws Exception {
		this.con.close();
	}

}
