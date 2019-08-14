package org.rajneesh.javaproject.model;

import java.util.Date;

public class Shows {

	private int showid;
	private String slotno;
	private String fromdate;
	private String todate;
	
	private Halls halls;
	private Movies movies;
	
	public Shows() {
	
	}

	public Shows(int showid, String slotno, String fromdate, String todate) {
	
		this.showid = showid;
		this.slotno = slotno;
		this.fromdate = fromdate;
		this.todate = todate;
		
	}

	public int getShowid() {
		return showid;
	}

	public void setShowid(int showid) {
		this.showid = showid;
	}

	public String getSlotno() {
		return slotno;
	}

	public void setSlotno(String slotno) {
		this.slotno = slotno;
	}

	public String getFromdate() {
		return fromdate;
	}

	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}

	public String getTodate() {
		return todate;
	}

	public void setTodate(String todate) {
		this.todate = todate;
	}

	public Halls getHalls() {
		return halls;
	}

	public void setHalls(Halls halls) {
		this.halls = halls;
	}

	public Movies getMovies() {
		return movies;
	}

	public void setMovies(Movies movies) {
		this.movies = movies;
	}

	
}
