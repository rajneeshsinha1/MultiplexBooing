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
import org.rajneesh.javaproject.model.Bookings;
import org.rajneesh.javaproject.model.Shows;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

@WebServlet("/booking")
public class BookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		MultiplexDao dao = new MultiplexDao();
		Connection conn = dao.getConnectin();

		String moviename = request.getParameter("moviename");
		String movielanguage = request.getParameter("movielanguage");
		String showdate = request.getParameter("showdate");
		String seattypedesc = request.getParameter("seattypedesc");
		String noseats = request.getParameter("noofseats");
		String usid = request.getParameter("uid");
		int userid = Integer.parseInt(usid);
		int noofseats = Integer.parseInt(noseats);
		String slotno = request.getParameter("slotno");
		PrintWriter writer = response.getWriter();
		if(noofseats <= 0){
			writer.println("Atleast one seat has to be selected to book a movie");
			return;
		}
		try {

			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

			PreparedStatement pstmt = conn.prepareStatement("insert into Bookings values(?,?,?,?,?,?,?)");

			PreparedStatement mstmt = conn.prepareStatement("select movieid from movies where moviename = ? and movieslanguage =  ?");
			mstmt.setString(1, moviename);
			mstmt.setString(2, movielanguage);

			ResultSet mresultset = mstmt.executeQuery();
			int movieid = 0;
			while (mresultset.next()) {
				movieid = Integer.parseInt(mresultset.getString(1));
			}
			PreparedStatement sstmt = conn.prepareStatement("select * from shows where movieid = ?");
			sstmt.setInt(1, movieid);
			ResultSet sresultset = sstmt.executeQuery();
			Shows show = new Shows();
			while (sresultset.next()) {
				show.setSlotno(sresultset.getString(4));
				show.setFromdate(sresultset.getString(5));
				show.setTodate(sresultset.getString(6));
			}
		
			Integer year = Integer.parseInt(showdate.substring(0, 4));
			Integer month = Integer.parseInt(showdate.substring(5, 7));
			Integer day = Integer.parseInt(showdate.substring(8, 10));
			showdate = new String();
			if (month < 10) {
				showdate = day + "-0" + month + "-" + year;
			}
			if (day < 10) {
				showdate = "0" + day + "-" + month + "-" + year;
			}
			if (month > 9 && day > 9) {
				showdate = day + "-" + month + "-" + year;
			}

			Date sdate2 = new Date();
			try {
				sdate2 = sdf.parse(showdate);

			} catch (ParseException | java.text.ParseException e1) {

				e1.printStackTrace();
			}
			if(!(slotno.equals(show.getSlotno()))){
				writer.println("There is no movie for "+ slotno + " on "+ sdate2);
				return;
			}

			String fromdate2 = show.getFromdate();
			Integer fday = Integer.parseInt(fromdate2.substring(0, 2));
			Integer fmonth = Integer.parseInt(fromdate2.substring(3, 5));
			Integer fyear = Integer.parseInt(fromdate2.substring(6, 10));

			Date date3 = new Date();
			try {
				date3 = sdf.parse(fromdate2);

			} catch (ParseException | java.text.ParseException e1) {

				e1.printStackTrace();
			}

			if (!(sdate2.after(date3) || (sdate2.getDate() == date3.getDate() && sdate2.getMonth() == date3.getMonth()
					&& sdate2.getYear() == date3.getYear()))) {
				out.println("you have selected date before today date");
				return;
			}
			String todate2 = show.getTodate();

			Date tdate4 = new Date();
			try {
				tdate4 = sdf.parse(todate2);

			} catch (ParseException | java.text.ParseException e1) {

				e1.printStackTrace();
			}
			if (!(sdate2.before(tdate4) || (sdate2.getDate() == tdate4.getDate()
					&& sdate2.getMonth() == tdate4.getMonth() && sdate2.getYear() == tdate4.getYear()))) {
				out.println("Right now this show is not available");
				return;
			}
			PreparedStatement st = conn.prepareStatement("select * from shows where slotno = ?, fromdate = ? and todate = ?");
			st.setString(1, show.getSlotno());
			st.setString(2, show.getFromdate());
			st.setString(3, show.getTodate());

			ResultSet sttset = sstmt.executeQuery();
			int showid = 0;
			while (sttset.next()) {

				showid = Integer.parseInt(sttset.getString(1));

			}

			PreparedStatement bstmt = conn.prepareStatement("select * from bookings");
			ResultSet resultset = bstmt.executeQuery();

			Bookings booking = new Bookings();

			while (resultset.next()) {

				int bookingId = Integer.parseInt(resultset.getString(1));
				booking.setBookingid(bookingId);

			}
			Date bdate = new Date();
			String bookeddate = sdf.format(bdate);

			pstmt.setInt(1, (booking.getBookingid() + 1));
			pstmt.setInt(2, showid);
			pstmt.setInt(3, userid);
			pstmt.setString(4, bookeddate);
			pstmt.setString(5, showdate);
			pstmt.setString(6, seattypedesc);
			pstmt.setInt(7, noofseats);

			pstmt.executeUpdate();

			writer.println("<h4>you have booked " + moviename + " successfully on "+ showdate + " at " + show.getSlotno() + "</h4>");
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
