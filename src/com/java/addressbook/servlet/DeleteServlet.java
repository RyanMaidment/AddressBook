package com.java.addressbook.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.java.addressbook.dao.ContactDao;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	ContactDao contactDao = new ContactDao();
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String id=request.getParameter("id");
		
		contactDao.delete(id);
		
		HttpSession httpSession = request.getSession(false);
		if(httpSession.getAttribute("Employee") != null) {
			response.sendRedirect("/AddressBook/employee.jsp?");
		}
		else if(httpSession.getAttribute("Manager") != null)
		response.sendRedirect("/AddressBook/manager.jsp?");

	}
}
	