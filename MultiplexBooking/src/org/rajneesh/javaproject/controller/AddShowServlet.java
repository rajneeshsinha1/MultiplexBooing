package org.rajneesh.javaproject.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.rajneesh.javaproject.dao.MultiplexDao;
import org.rajneesh.javaproject.model.Shows;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

@WebServlet("/addshow")
public class AddShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		MultiplexDao dao = new MultiplexDao();
		Connection conn = dao.getConnectin();

		String hallId = request.getParameter("hallid");
		int hallid = Integer.parseInt(hallId);
		String moviename = request.getParameter("moviename");
		String movielanguage = request.getParameter("movielanguage");
		String slotno = request.getParameter("slotno");
		String fromdate = request.getParameter("fromdate");
		String todate = request.getParameter("todate");

		PrintWriter writer = response.getWriter();

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

			Integer year = Integer.parseInt(fromdate.substring(0, 4));
			Integer month = Integer.parseInt(fromdate.substring(5, 7));
			Integer day = Integer.parseInt(fromdate.substring(8, 10));

			fromdate = new String();

			if (month < 10) {
				fromdate = day + "-0" + month + "-" + year;
			}
			if (day < 10) {
				fromdate = "0" + day + "-" + month + "-" + year;
			}
			if (month > 9 && day > 9) {
				fromdate = day + "-" + month + "-" + year;
			}

			Date date2 = new Date();
			try {
				date2 = sdf.parse(fromdate);

			} catch (ParseException e1) {
				e1.printStackTrace();
			}

			Date curdate = new Date();
			sdf.format(curdate);

			PrintWriter out = response.getWriter();

			if (!(date2.after(curdate) || (date2.getDate() == curdate.getDate()
					&& date2.getMonth() == curdate.getMonth() && date2.getYear() == curdate.getYear()))) {
				out.println("you have selected date before today date");
				return;
			}

			Integer tyear = Integer.parseInt(todate.substring(0, 4));
			Integer tmonth = Integer.parseInt(todate.substring(5, 7));
			Integer tday = Integer.parseInt(todate.substring(8, 10));

			todate = new String();

			if (tmonth < 10) {
				todate = tday + "-0" + tmonth + "-" + tyear;
			}
			if (tday < 10) {
				todate = "0" + tday + "-" + tmonth + "-" + tyear;
			}
			if (tmonth > 9 && tday > 9) {
				todate = tday + "-" + tmonth + "-" + tyear;
			}

			Date tdate2 = new Date();
			try {
				tdate2 = sdf.parse(todate);

			} catch (ParseException e1) {
				e1.printStackTrace();
			}

			if (!(tdate2.after(date2) || (tdate2.getDate() == date2.getDate() && tdate2.getMonth() == date2.getMonth()
					&& tdate2.getYear() == date2.getYear()))) {
				writer.println("you have selected todate before fromdate");
				return;
			}

			PreparedStatement pstmt = conn.prepareStatement("insert into shows values(?,?,?,?,?,?)");

			PreparedStatement stmt = conn.prepareStatement("select * from shows");
			ResultSet resultset = stmt.executeQuery();

			Shows show = new Shows();

			while (resultset.next()) {

				int showId = Integer.parseInt(resultset.getString(1));
				show.setShowid(showId);

			}
			PreparedStatement mstmt = conn
					.prepareStatement("select movieid from movies where moviename = ? and movieslanguage =  ?");
			mstmt.setString(1, moviename);
			mstmt.setString(2, movielanguage);

			ResultSet mresultset = mstmt.executeQuery();
			int movieid = 0;
			while (mresultset.next()) {

				movieid = Integer.parseInt(mresultset.getString(1));

			}

			pstmt.setInt(1, (show.getShowid() + 1));
			pstmt.setInt(2, hallid);
			pstmt.setInt(3, movieid);
			pstmt.setString(4, slotno);
			pstmt.setString(5, fromdate);
			pstmt.setString(6, todate);
			;

			pstmt.executeUpdate();

			writer.println(" show added successfully");
			// writer.println((user.getUserid()+1));
		} catch (NumberFormatException e) {
			writer.println("numberformate failed");
			e.printStackTrace();
		} catch (SQLException e1) {
			writer.println("sql exception");
			e1.printStackTrace();
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}

	}
}
