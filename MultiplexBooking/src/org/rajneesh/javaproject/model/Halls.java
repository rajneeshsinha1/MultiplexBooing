package org.rajneesh.javaproject.model;

public class Halls {
	private int hallid;
	private String halldesc;
	private int totalcapacity;

	public Halls() {

	}

	public Halls(int hallid, String halldesc, int totalcapacity) {
		super();
		this.hallid = hallid;
		this.halldesc = halldesc;
		this.totalcapacity = totalcapacity;
	}

	public int getHallid() {
		return hallid;
	}

	public void setHallid(int hallid) {
		this.hallid = hallid;
	}

	public String getHalldesc() {
		return halldesc;
	}

	public void setHalldesc(String halldesc) {
		this.halldesc = halldesc;
	}

	public int getTotalcapacity() {
		return totalcapacity;
	}

	public void setTotalcapacity(int totalcapacity) {
		this.totalcapacity = totalcapacity;
	}

}
