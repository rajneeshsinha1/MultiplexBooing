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
import org.rajneesh.javaproject.model.Halls;


@WebServlet("/addhallcapacity")
public class AddHallCapacityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		MultiplexDao dao = new MultiplexDao();
		Connection conn = dao.getConnectin();

		String hallid = request.getParameter("hallid");
		String seattype = request.getParameter("seattype");
		String seatct = request.getParameter("seatcount");
		String seatfr = request.getParameter("seatfare");

		int seatcount = Integer.parseInt(seatct);
		int seatfare = Integer.parseInt(seatfr);
		PrintWriter writer = response.getWriter();

		try {

			PreparedStatement pstmt = conn.prepareStatement("insert into hallcapacities values(?,?,?,?)");

			PreparedStatement stmt = conn.prepareStatement("select * from halls");
			ResultSet resultset = stmt.executeQuery();

			Halls hall = new Halls();

			while (resultset.next()) {

				int totalcapacity = Integer.parseInt(resultset.getString(3));

				hall.setTotalcapacity(totalcapacity);

				if (hall.getTotalcapacity() < seatcount) {

					writer.print("total hall capacity is less than this hall capacity");
					return;
				}
			}
			pstmt.setString(1, hallid);
			pstmt.setString(2, seattype);
			pstmt.setInt(3, seatcount);
			pstmt.setInt(4, seatfare);

			pstmt.executeUpdate();

			writer.println("Hall capacity added successfully");
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