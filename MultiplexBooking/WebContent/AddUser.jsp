<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AddUser</title>
</head>
<body>
<h4 style="color: blue" align="center">Registration Form</h4>
<form action="adduser" method="post">
<table style="background-color: lightgreen" align="center">
<tr><td>UserName:</td><td><input type="text" name="username" required  placeholder="username"></td></tr>
<tr><td>UserType:</td><td><select name="usertype">
                                  <option value="Admin">Admin</option>
                                  <option value="Customer">Customer</option>
                                  </select></td></tr>
<tr><td>MobileNo:</td><td><input type="number" name="mobileno" required></td></tr>
<tr><td>EmailId:</td><td><input type="email" name="email" placeholder="emailid"></td></tr>
<tr><td>Password:</td><td><input type="password" name="password" required></td></tr>
<tr><td>  </td><td><input type="submit"  value="Register"></td></tr>
</table>
</form>
</body>
</html>