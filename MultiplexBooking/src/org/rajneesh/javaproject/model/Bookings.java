package org.rajneesh.javaproject.model;

import java.util.Date;

public class Bookings {
	
	private int bookingid;
	private Date bookeddate;
	private int noofseats;
	
	
	private Shows shows;
	private Users users;
	
	public Bookings() {
		
	}

	public Bookings(int bookingid, Date bookeddate, int noofseats) {
		super();
		this.bookingid = bookingid;
		this.bookeddate = bookeddate;
		this.noofseats = noofseats;
		
	}

	public int getBookingid() {
		return bookingid;
	}

	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}

	public Date getBookeddate() {
		return bookeddate;
	}

	public void setBookeddate(Date bookeddate) {
		this.bookeddate = bookeddate;
	}

	public int getNoofseats() {
		return noofseats;
	}

	public void setNoofseats(int noofseats) {
		this.noofseats = noofseats;
	}

	public Shows getShows() {
		return shows;
	}

	public void setShows(Shows shows) {
		this.shows = shows;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}
	
	
	
	
	
	

}
