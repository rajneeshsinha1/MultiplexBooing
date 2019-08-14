package org.rajneesh.javaproject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MultiplexDao {

	Connection conn;

	public Connection getConnectin() {

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/multiplexbooking", "root", "rockey123");
		} catch (ClassNotFoundException e1) {

			e1.printStackTrace();

		} catch (SQLException e) {

			e.printStackTrace();
		} catch (InstantiationException e) {

			e.printStackTrace();
		} catch (IllegalAccessException e) {

			e.printStackTrace();
		}
		return conn;

	}

}
