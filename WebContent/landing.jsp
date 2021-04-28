<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.java.addressbook.*"%>
<!DOCTYPE html>
<html>
<head>
	<title>Address Book</title>
</head>
<link href="/AddressBook/style.css" type="text/css" rel="stylesheet" />
<body>
	<div class="form">
		<ul class="tab-group">
			<li class="tab active"><a href="/AddressBook/signUp.jsp">Sign Up</a></li>
		</ul>

				<div id="login">
					<h1>Welcome back!</h1>
					
					<form name="form" action="<%=request.getContextPath()%>/LoginServlet" method="post">
					
						<div class="field-wrap">
						<label>
							User Name<span class="req">*</span>
						</label>
						<input type="text" name="userName" required autocomplete="off" />
						</div>
						
						<div class="field-wrap">
						<label>
							Password<span class="req">*</span>
						</label>
						<input type="password" name="password" required autocomplete="off" />
						</div>
						
						<input type="submit" value="Login"></input>
											</form>
				</div>
		</div>
		</body>
		</html>