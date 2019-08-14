package org.rajneesh.javaproject.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.rajneesh.javaproject.dao.MultiplexDao;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		MultiplexDao dao = new MultiplexDao();
		Connection conn = dao.getConnectin();

		try {
			PreparedStatement ps = conn.prepareStatement("select * from users where username = ? and password = ?");
			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int usid = Integer.parseInt(rs.getString(1));

				String usertype = rs.getString(3);
				// writer.println(usertype);
				if ("Admin".equals(usertype)) {
					request.setAttribute("uid", usid);
					RequestDispatcher dispatcher = request.getRequestDispatcher("ManageHall.jsp");
					dispatcher.forward(request, response);

					return;
				} else {

					request.setAttribute("uid", usid);
					RequestDispatcher dispatcher = request.getRequestDispatcher("Booking.jsp");
					dispatcher.forward(request, response);
					return;

				}
			}
			request.setAttribute("message", "Invalid username or password, please try again!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
			dispatcher.forward(request, response);
			return;
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}
