<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Add Contact</title>
</head>
<link href="/AddressBook/style.css" type="text/css" rel="stylesheet" />
			<div class="row">
				<div class="col-8 offset-2">
					<h2>Contacts - New</h2>
					<form class="form-group needs-validation" action="${pageContext.request.contextPath}/AddServlet" method="post">
					    <div class="form-group">
					        <label id="firstName">First Name</label>
					        <input type="text" id="firstName" name="firstName" placeholder="First Name" />
					    </div>
					    <div class="form-group">
					        <label id="lastName">Last Name</label>
					        <input type="text" id="lastName" name="lastName" placeholder="Last Name" />
					    </div>
					    <div class="form-group">
					        <label id="phoneNum">Phone Number</label>
					        <input type="text" id="phoneNum"name="phoneNum" placeholder="Phone Number" />
					    </div>
					    <div class="form-group">
					        <label id="email">Email Address</label>
					        <input type="text" id="email" name="email" placeholder="Enter Email Address"/>
					    </div>
					    <div class="form-group">
					        <label id="address">Address</label>
					        <input type="text" id="address" name="address" placeholder="Address"/>
					    </div>
					<div class="form-group">
						<label>
							Classified<span class="req">*</span>
						</label>
						<input type="checkbox" name="classified" value="1"/>
					</div>
					    <div class="form-group">
					        <button type="submit">Submit</button>
					    </div>
					</form>
				</div>
			</div>
			</html>