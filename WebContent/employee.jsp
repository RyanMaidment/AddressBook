<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.java.addressbook.dao.Database"%>
<!DOCTYPE html>
<html>
<head>
<title>Employee Page</title>
</head>
<link href="/AddressBook/style.css" type="text/css" rel="stylesheet" />
<h1>
	Welcome
	<%=session.getAttribute("userName")%>
</h1>
<div class="row">
	<div class="col">
		<h2>Contacts - List</h2>
		<%
		Connection connection = Database.getDBConnection();
		Statement statement = connection.createStatement();
		ResultSet resultset = statement.executeQuery("select * from Contact where classified=0");
		%>
		<table class="table striped">
			<thead>
				<tr>
					<td>ID</td>
					<td>First Name</td>
					<td>Last Name</td>
					<td>Phone Number</td>
					<td>Email Address</td>
					<td>Address</td>
					<td>Action</td>
				</tr>
			</thead>
			<tbody>
				<%
				while (resultset.next()) {
				%>
				<tr>
					<td><%=resultset.getString(1)%></td>
					<td><%=resultset.getString(2)%></td>
					<td><%=resultset.getString(3)%></td>
					<td><%=resultset.getString(4)%></td>
					<td><%=resultset.getString(5)%></td>
					<td><%=resultset.getString(6)%></td>
					<td><a href="/AddressBook/DeleteServlet?id=<%=resultset.getString("id") %>"><button type="button" class="delete">Delete</button></a></td>
					<td><a href="editContact.jsp?id=<%=resultset.getString("id") %>"><button type="button" class="edit">Edit</button></a></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>
			<a href="/AddressBook/addContact.jsp"> <button type="button">Add Contact</button></a>
</div>
</html>