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
<html>
<head>
<title>Booking</title>
</head>
<body>
<p style="color: blue" align="center">Welcome to Multiplex movie booking</p>
<form action="booking" method="post">
<input type="hidden" value="${uid}" name="uid">
<table style="background-color: lightblue" align="center">

<tr><td>MovieName:</td><td><select name="moviename">
			                       <option value="-1">select movie</option>
			<%
				try {
					connection = DriverManager.getConnection(connectionUrl + database, userid, password);
					statement = connection.createStatement();
					String sql = "select * from movies";
					rs = statement.executeQuery(sql);
					while (rs.next()) {
			%>
			                       <option><%=rs.getString("moviename")%></option>
			<%
				}
				} catch (Exception e) {
					e.printStackTrace();
				}
			%>
		</select></td></tr>
<tr><td>MovieLanguage:</td><td><select name="movielanguage">
			                           <option value="-1">select movieLanguage</option>
			<%
				try {
					connection = DriverManager.getConnection(connectionUrl + database, userid, password);
					statement = connection.createStatement();
					String sql = "select * from movies";
					rs = statement.executeQuery(sql);
					while (rs.next()) {
			%>
			                           <option><%=rs.getString("movieslanguage")%></option>
			<%
				}
				} catch (Exception e) {
					e.printStackTrace();
				}
			%>
		                       </select></td></tr>
<tr><td>Show Date:</td><td><input type="date" name="showdate" required></td></tr>
<tr><td>Slot Number:</td> 
<td><input type="radio" value="10:30 AM" name="slotno">Morning Show</td>
<td><input type="radio" value="2:00 PM" name="slotno">AfterNoon Show</td>
<td><input type="radio" value="5:00 PM" name="slotno">Evening Show</td>
<td><input type="radio" value="8:00 PM" name="slotno">Night Show</td>

<tr><td>Seat Type Desc:</td><td><select name="seattypedesc">
                                        <option value="Regular">Regular</option>
                                        <option value="Executive">Executive</option>
                                        <option value="Premium">Premium</option>
                                </select></td></tr>
<tr><td>No Of Seats:</td><td><input type="number" name="noofseats" required></td></tr>
<tr><td></td><td><input type="submit" value="Book"></td></tr>
</table>
</form>
</body>
</html>