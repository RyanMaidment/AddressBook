package com.java.addressbook.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.addressbook.dao.ContactDao;
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	String id = request.getParameter("id");
	String firstName=request.getParameter("firstName");
	String lastName=request.getParameter("lastName");
	String phoneNum=request.getParameter("phoneNum");
	String email=request.getParameter("email");
	String address=request.getParameter("address");
	if(id != null)
	{
	ContactDao contactDao = new ContactDao();
	try {
		contactDao.edit(id, firstName, lastName, phoneNum, email, address);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	HttpSession httpSession = request.getSession(false);
	if(httpSession.getAttribute("Employee") != null) {
		response.sendRedirect("/AddressBook/employee.jsp?");
	}
	else if(httpSession.getAttribute("Manager") != null)
	response.sendRedirect("/AddressBook/manager.jsp?");
	
	else {
		System.out.println("It didnt work.");
	}
	}
	
	else
	{
		System.out.println("There is a problem in updating Contact.");
	}
	}
}
