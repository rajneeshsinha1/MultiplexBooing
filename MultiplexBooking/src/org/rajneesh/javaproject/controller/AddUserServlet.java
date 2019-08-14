package org.rajneesh.javaproject.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.rajneesh.javaproject.dao.MultiplexDao;
import org.rajneesh.javaproject.model.Users;

@WebServlet("/adduser")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		MultiplexDao dao = new MultiplexDao();
		Connection conn = dao.getConnectin();

		String username = request.getParameter("username");
		String usertype = request.getParameter("usertype");
		String mobile = request.getParameter("mobileno");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		PrintWriter writer = response.getWriter();
		try {
			long mobileno = Long.parseLong(mobile);
			PreparedStatement pstmt = conn.prepareStatement("insert into Users values(?,?,?,?,?,?)");

			PreparedStatement stmt = conn.prepareStatement("select * from Users");
			ResultSet resultset = stmt.executeQuery();

			Users user = new Users();

			while (resultset.next()) {

				int userId = Integer.parseInt(resultset.getString(1));
				user.setUserid((userId));
			}

			pstmt.setInt(1, (user.getUserid() + 1));
			pstmt.setString(2, username);
			pstmt.setString(3, usertype);
			pstmt.setLong(4, mobileno);
			pstmt.setString(5, email);
			pstmt.setString(6, password);

			pstmt.executeUpdate();

			writer.println("You have registered successfully");
			// writer.println((user.getUserid()+1));
		} catch (NumberFormatException e) {
			writer.println("numberformate failed");
			e.printStackTrace();
		} catch (SQLException e1) {
			writer.println("sql exception");
			e1.printStackTrace();
		}

	}

}
