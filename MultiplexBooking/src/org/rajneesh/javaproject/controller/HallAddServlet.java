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

@WebServlet("/halladd")
public class HallAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		MultiplexDao dao = new MultiplexDao();
		Connection conn = dao.getConnectin();

		String halldesc = request.getParameter("halldesc");
		String hallcapty = request.getParameter("hallcapacity");

		PrintWriter writer = response.getWriter();
		try {
			int hallcapacity = Integer.parseInt(hallcapty);
			if (hallcapacity < 200) {
				writer.println("hall capacity is less");
				return;
			}
			PreparedStatement pstmt = conn.prepareStatement("insert into Halls values(?,?,?)");

			PreparedStatement stmt = conn.prepareStatement("select * from Halls");
			ResultSet resultset = stmt.executeQuery();

			Halls hall = new Halls();

			while (resultset.next()) {

				int hallId = Integer.parseInt(resultset.getString(1));
				hall.setHallid(hallId);

			}
			request.setAttribute("hallid", hall.getHallid());
			pstmt.setInt(1, (hall.getHallid() + 1));
			pstmt.setString(2, halldesc);
			pstmt.setInt(3, hallcapacity);

			pstmt.executeUpdate();

			writer.println("Hall details added successfully");

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
