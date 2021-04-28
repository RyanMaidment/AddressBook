package com.java.addressbook.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletResponse;

import com.java.addressbook.bean.ContactBean;

public class ContactDao {
	HttpServletResponse response;
	public void add(ContactBean contact) {		
		try {
				Connection connection = Database.getDBConnection();
				PreparedStatement ps = null;
				String sql="INSERT INTO Contact(firstName, lastName, phoneNum, email, address, classified) VALUES (?, ?, ?, ?, ?, ?)";
				ps = connection.prepareStatement(sql);
				ps.setString(1, contact.getFirstName());
				ps.setString(2, contact.getLastName());
				ps.setString(3, contact.getPhoneNum());
				ps.setString(4, contact.getEmail());
				ps.setString(5, contact.getAddress());
				ps.setByte(6, contact.getIsClassified());
				ps.executeUpdate();
		} catch (SQLException sqlException) {
			sqlException.getMessage();
		}
	}
	
	public void delete(String id) {
		try
		{
		    Connection connection = Database.getDBConnection();
		    Statement statement = connection.createStatement() ;
		statement.executeUpdate("DELETE FROM Contact WHERE id="+id);
		
		System.out.println("Contact Deleted Successfully!");
		
		}catch(Exception e)
		{
		System.out.print(e);
		e.printStackTrace();
		}
	}
	
	public void edit(String id, String firstName, String lastName, String phoneNum, String email, String address) throws SQLException {
		PreparedStatement ps = null;
		Connection connection = Database.getDBConnection();
		String sql="Update Contact set id=?,firstName=?,lastName=?,phoneNum=?,email=?,address=? where id="+id;
		ps = connection.prepareStatement(sql);
		ps.setString(1,id);
		ps.setString(2, firstName);
		ps.setString(3, lastName);
		ps.setString(4, phoneNum);
		ps.setString(5, email);
		ps.setString(6, address);
		int i = ps.executeUpdate();
		if(i > 0)
		{
		System.out.println("Contact Updated Successfully");
		}
		else
		{
			System.out.println("There is a problem in updating Contact.");
		}
	}
}
