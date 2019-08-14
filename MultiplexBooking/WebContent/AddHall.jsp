<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AddHall</title>
</head>
<body>
<h4 style="color: blue" align="center">Add Hall</h4>
<form action="halladd" method="post">
<table align="center" style="background-color: lightblue;">
<tr><td>Enter Hall Desc:</td><td><input type="text" name="halldesc"></td></tr>
<tr><td>Enter Hall Capacity:</td><td><input type="number" name="hallcapacity" required></td></tr>
<tr><td></td><td><input type="submit"  value="AddHall"></td></tr>
</table>
</form>
</body>
</html>