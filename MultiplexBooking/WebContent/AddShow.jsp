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
<h4 style="color: blue" align="center">Add Show</h4>
<form action="addshow" method="post">
<table align="center" style="background-color: lightblue;">
<tr><td>Hallid:</td><td><select name="hallid">
			                    <option value="-1">hallid</option>
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

				} catch (Exception e) {
					e.printStackTrace();
				}
%>
                           </select></td></tr> 
<tr><td>MovieName:</td><td><select name="moviename">
			                       <option value="-1">select movie</option>
<%
				try {
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
		                  </select><br>
<tr><td>MovieLanguage:</td><td><select name="movielanguage">
			                           <option value="-1">select movie</option>
<%
				try {
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
		                       </select><br> 
<tr><td>Slot Number:</td> 
<td><input type="radio" value="10:30 AM" name="slotno">Morning Show</td>
<td><input type="radio" value="2:00 PM" name="slotno">AfterNoon Show</td>
<td><input type="radio" value="5:00 PM" name="slotno">Evening Show</td>
<td><input type="radio" value="8:00 PM" name="slotno">Night Show</td>
<tr><td>From Date:</td><td><input type="date" name="fromdate" required></td></tr>
<tr><td>To Date:</td><td><input type="date" name="todate" required></td></tr>
<tr><td></td><td><input type="submit" value="AddShow"></td>
</table>
</form>
</body>
</html>