package com.java.addressbook.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.java.addressbook.bean.LoginBean;
 
 
public class LoginDao {
    String role = "";
    String usernameDB = "";
public String authenticateUser(LoginBean loginBean)
{
    String userName = loginBean.getUserName();
    String password = loginBean.getPassword();
 
    Connection con = null;
    Statement statement = null;
    ResultSet resultSet = null;
 
    String usernameDB = "";
    String passwordDB = "";
 
    try
    {
    	 con = Database.getDBConnection();
         statement = con.createStatement();
         resultSet = statement.executeQuery("select userName,password,manager from User");
         
        while(resultSet.next())
        {
            usernameDB = resultSet.getString("userName");
            passwordDB = resultSet.getString("password");
            role = resultSet.getString("manager");
 
            if(userName.equals(usernameDB) && password.equals(passwordDB) && role.equals("1"))
            return "Manager_Role";
            else if(userName.equals(usernameDB) && password.equals(passwordDB) && role.equals("0"))
            return "Employee_Role";
        }
    }
    catch(SQLException e)
    {
        e.printStackTrace();
    }
    return "Invalid user credentials";
}
}