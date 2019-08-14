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
<form action="bookingdetails" method="post">
<table align="center" style="background-color: lightblue;">
<tr><td>Select a HallId:</td><td><select name="showid">
			                    <option value="-1">showid</option>
<%
				try {
					connection = DriverManager.getConnection(connectionUrl + database, userid, password);
					statement = connection.createStatement();
					String sql = "select * from shows";
					rs = statement.executeQuery(sql);
					while (rs.next()) {
						
%>

			                    <option><%=rs.getString("showid")%></option>
<%
				}

				} catch (Exception e) {
					e.printStackTrace();
				}
%>
                           </select></td></tr> 
<tr><td></td><td><input type="submit" value="GetbookingDetails"></td>
</table>
</form>
</body>
</html>