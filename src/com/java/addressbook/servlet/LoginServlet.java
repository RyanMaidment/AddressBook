package com.java.addressbook.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import com.java.addressbook.dao.LoginDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.addressbook.bean.LoginBean;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
 
public LoginServlet() {
}
 
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
    String userName = request.getParameter("userName");
    String password = request.getParameter("password");
 
    LoginBean loginBean = new LoginBean();
 
    loginBean.setUserName(userName);
    loginBean.setPassword(password);
 
    LoginDao loginDao = new LoginDao();
    try
    {
        String userValidate = loginDao.authenticateUser(loginBean);
 
        if(userValidate.equals("Manager_Role"))
        {
 
            HttpSession session = request.getSession();
            session.setAttribute("Manager", userName);
            session.setAttribute("userName", userName);
 
            request.getRequestDispatcher("/manager.jsp").forward(request, response);
        }
        else if(userValidate.equals("Employee_Role"))
        {
        	
            HttpSession session = request.getSession();
            session.setAttribute("Employee", userName);
            session.setAttribute("userName", userName);
 
            request.getRequestDispatcher("/employee.jsp").forward(request, response);
        }
   
        else
        {
 
            request.getRequestDispatcher("/landing.jsp").forward(request, response);
        }
    }
    catch (IOException e1)
    {
        e1.printStackTrace();
    }
    catch (Exception e2)
    {
        e2.printStackTrace();
    }
}
}