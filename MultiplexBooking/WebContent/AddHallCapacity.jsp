<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
	String driver = "com.mysql.jdbc.Driver";
	String connectionUrl = "jdbc:mysql://localhost:3306/";
	String database = "multiplexbooking";
	String userid = "root";
	String password = "rockey123";
	try {
		Class.forName(driver);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	Connection connection = null;
	Statement statement = null;
	ResultSet rs = null;
%>
<!DOCTYPE html>
<html>
<body>
<h4 style="color: blue" align="center">Add Hall Capacity</h4>
<form action="addhallcapacity" method="post">
<table align="center" style="background-color: lightblue">
<tr><td>Hall Id</td><td><select name="hallid">
		<option value="-1">Hallid</option>
<%
			try {
				connection = DriverManager.getConnection(connectionUrl + database, userid, password);
				statement = connection.createStatement();
				String sql = "select * from halls";
				rs = statement.executeQuery(sql);
				while (rs.next()) {
%>
		<option><%=rs.getString("hallid")%></option>
<%
			}
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
%>
	</select></td></tr>
<tr><td>Seat type desc:</td><td><input type="text" name="seattype"  required></td></tr>
<tr><td>Seat count:</td><td><input type="number" name="seatcount" required></td></tr>
<tr><td>Seat fare:</td><td><input type="number" name="seatfare" required></td></tr>
<tr><td></td><td><input type="submit" value="AddHallCapacity"></td></tr>
</table>
</form>
</body>
</html>