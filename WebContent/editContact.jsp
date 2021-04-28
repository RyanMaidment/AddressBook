<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.java.addressbook.dao.Database"%>
<%
try {
	ResultSet resultSet = null;
	String id = request.getParameter("id");
	Connection connection = Database.getDBConnection();
	Statement statement = connection.createStatement();
	String sql = "select * from Contact where id=" + id;
	resultSet = statement.executeQuery(sql);
	while (resultSet.next()) {
%>
<!DOCTYPE html>
<html>
<link href="/AddressBook/style.css" type="text/css" rel="stylesheet" />
<body>
	<h1>Edit Contact</h1>
	<form method="post" action="<%=request.getContextPath()%>/EditServlet">
		<input type="hidden" name="id" value="<%=resultSet.getString("id")%>">
			<br>First name:<input type="text" name="firstName"
			value="<%=resultSet.getString("firstName")%>">
			<br>Lastname:<input type="text" name="lastName"
			value="<%=resultSet.getString("lastName")%>">
			<br>Phone Number:<input type="text" name="phoneNum"
			value="<%=resultSet.getString("phoneNum")%>"> 
			<br>Email:<input type="text" name="email"
			value="<%=resultSet.getString("email")%>">
			<br>Address:<input type="text" name="address"
			value="<%=resultSet.getString("address")%>">
		<br><input type="submit" value="submit">
	</form>
	<%
	}
	} catch (Exception e) {
	e.printStackTrace();
	}
	%>
</body>
</html>