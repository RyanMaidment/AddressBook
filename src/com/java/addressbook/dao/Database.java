package com.java.addressbook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

	   static final String database = "[REDACTED]";
	   static final String username = "[REDACTED]";
	   static final String password = "[REDACTED]";
	   
	   public static Connection getDBConnection() {
		   Connection connection = null;
	   try{


	      System.out.println("Connecting to database...");
	      Class.forName("com.mysql.jdbc.Driver");
	     connection = DriverManager.getConnection(database, username, password);
	} catch(SQLException SQLException) {
		SQLException.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return connection;
	}
}