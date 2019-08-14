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
import org.rajneesh.javaproject.model.Movies;


@WebServlet("/addmovie")
public class AddMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		MultiplexDao dao = new MultiplexDao();
		Connection conn = dao.getConnectin();

		String moviename = request.getParameter("moviename");
		String movielanguage = request.getParameter("movielanguage");

		PrintWriter writer = response.getWriter();

		try {

			PreparedStatement pstmt = conn.prepareStatement("insert into movies values(?,?,?)");

			PreparedStatement stmt = conn.prepareStatement("select * from Movies");
			ResultSet resultset = stmt.executeQuery();

			Movies movie = new Movies();

			while (resultset.next()) {

				int movieId = Integer.parseInt(resultset.getString(1));
				movie.setMovieid(movieId);
				movie.setMoviename(resultset.getString(2));
				movie.setMovielanguage(resultset.getString(3));
				if (movie.getMoviename().equals(moviename) && movie.getMovielanguage().equals(movielanguage)) {

					writer.print("Movie name and movie language already exists");
					return;
				}
			}

			pstmt.setInt(1, (movie.getMovieid() + 1));
			pstmt.setString(2, moviename);
			pstmt.setString(3, movielanguage);

			pstmt.executeUpdate();

			writer.println(" Movie added successfully");
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
