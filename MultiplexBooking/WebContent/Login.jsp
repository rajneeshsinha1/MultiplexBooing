<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<h1 style="color: Blue" align="center">Multiplex Login Form</h1>
<p style="color: red" align="center">${message}</p>
<body>
<form action="login" method="post">
	<table align="center" style="background-color: skyblue">
<tr><td>Enter UserName: </td><td><input type="text" name="username" required></td></tr>
<tr><td>Enter Password:</td><td> <input type="password" name="password" required /></td></tr>
<tr><td>  </td><td><input type="submit" name="submit" value="Login"><a href="AddUser.jsp">Register</a></td></tr>
</table>
</form>
</body>
</html>