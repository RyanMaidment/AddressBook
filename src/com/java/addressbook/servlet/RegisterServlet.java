package com.java.addressbook.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import com.java.addressbook.dao.Database;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	    String userName = request.getParameter("userName");
	    String password = request.getParameter("password");
	    String manager = request.getParameter("manager");
	    if(manager == null) {
	    	manager = "0";
	    }
	   Byte isManager;
	if(Integer.parseInt(manager) == 1 ) {
		isManager = 1;
	}
	
	else {
		isManager = 0;
	}
	 
	    try
	    {
	    Connection connection = Database.getDBConnection();
		PreparedStatement statement = connection.prepareStatement("INSERT INTO User(userName, password, manager) "
				+ "VALUES(?, ?, ?)");
			statement.setString(1, userName);
			statement.setString(2, password);
			statement.setByte(3, isManager);
			statement.executeUpdate();
	    }	    catch (Exception e2)
	    {
	        e2.printStackTrace();
	    }{
		request.getRequestDispatcher("/landing.jsp").forward(request, response);

	}
}
}
