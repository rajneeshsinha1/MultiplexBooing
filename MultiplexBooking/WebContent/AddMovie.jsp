<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AddMovie</title>
</head>
<body>
<h4 style="color: blue" align="center">Add Movie</h4>
<form action="addmovie" method="post">
<table align="center" style="background-color: lightblue">
<tr><td>Enter movie name:</td><td><input type="text"  name="moviename" required></td></tr>
<tr><td>Enter movie language:</td><td><input type="text" name="movielanguage"></td></tr>
<tr><td></td><td><input type="submit" value="AddMovie"></td></tr>
</table>
</form>
</body>
</html>