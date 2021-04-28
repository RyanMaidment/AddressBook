<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.java.addressbook.*"%>
<!DOCTYPE html>
<html>
<head>
<title>Register</title>
</head>
<link href="/AddressBook/addressBoolCss.css" type="text/css" rel="stylesheet" />
<form action="<%=request.getContextPath()%>/RegisterServlet"
	method="post">

	<h1>Register</h1>

	<div class="field-wrap">
		<label> User Name<span class="req">*</span>
		</label> <input type="text" name="userName" required autocomplete="off" />
	</div>


	<div class="field-wrap">
		<label> Password<span class="req">*</span>
		</label> <input type="password" name="password" required autocomplete="off" />
	</div>

	<div class="field-wrap">
		<label> Manager<span class="req">*</span>
		</label> <input type="checkbox" name="manager" value="1" />
	</div>

	<input type="submit" value="Register"></input>

</form>
</body>
</html>