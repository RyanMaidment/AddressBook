package com.java.addressbook.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.addressbook.bean.ContactBean;
import com.java.addressbook.dao.ContactDao;


@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ContactDao contactDao = new ContactDao();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String firstName = request.getParameter("firstName").trim();
    	String lastName = request.getParameter("lastName").trim();
    	String phoneNum = request.getParameter("phoneNum").trim();
    	String email = request.getParameter("email").trim();
    	String address = request.getParameter("address").trim();
    	String classified = request.getParameter("classified");
    	 if(classified == null) {
    		 classified = "0";
 	    }
    	Byte isClassified;
    	
    	if(Integer.parseInt(classified) == 1 ) {
    		isClassified = 1;
    	}
    	
    	else {
    		isClassified = 0;
    	}

	ContactBean contact = new ContactBean();
	contact.setFirstName(firstName);
	contact.setLastName(lastName);
	contact.setPhoneNum(phoneNum);
	contact.setEmail(email);
	contact.setAddress(address);
	contact.setIsClassified(isClassified);
	contactDao.add(contact);

	HttpSession httpSession = request.getSession(false);
	if(httpSession.getAttribute("Employee") != null) {
		response.sendRedirect("/AddressBook/employee.jsp?");
	}
	else if(httpSession.getAttribute("Manager") != null)
	response.sendRedirect("/AddressBook/manager.jsp?");
}
}
