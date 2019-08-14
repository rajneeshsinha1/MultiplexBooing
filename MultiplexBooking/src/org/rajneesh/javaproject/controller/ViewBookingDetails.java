package org.rajneesh.javaproject.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.rajneesh.javaproject.dao.MultiplexDao;
import org.rajneesh.javaproject.model.Bookings;

@WebServlet("/bookingdetails")
public class ViewBookingDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		boolean b = false;
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		String shid = request.getParameter("showid");
		int showid = Integer.parseInt(shid);
		MultiplexDao dao = new MultiplexDao();
		Connection conn = dao.getConnectin();
		try {
			Statement stmt = conn.createStatement();
			ResultSet resultset = stmt.executeQuery("select * from bookings where showid =" + showid);
			Bookings booking = new Bookings();
			while (resultset.next()) {
				booking.setBookingid(resultset.getInt(1));
				booking.setNoofseats(resultset.getInt(7));
				writer.println("For booking id " + booking.getBookingid() + " total no. of booked seat is "
						+ booking.getNoofseats() + ".....");
				b = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (b == false) {
			writer.println("There is no booking for showid " + showid);
		}
		b = false;
	}

}
