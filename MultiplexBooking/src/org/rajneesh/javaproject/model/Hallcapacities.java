package org.rajneesh.javaproject.model;

public class Hallcapacities {

	private String seattypedesc;
	private int seatcount;
	private int seatfare;
	private Halls halls;

	public Hallcapacities() {

	}

	public Hallcapacities(String seattypedesc, int seatcount, int seatfare) {
		super();
		this.seattypedesc = seattypedesc;
		this.seatcount = seatcount;
		this.seatfare = seatfare;
	}

	public String getSeattypedesc() {
		return seattypedesc;
	}

	public void setSeattypedesc(String seattypedesc) {
		this.seattypedesc = seattypedesc;
	}

	public int getSeatcount() {
		return seatcount;
	}

	public void setSeatcount(int seatcount) {
		this.seatcount = seatcount;
	}

	public int getSeatfare() {
		return seatfare;
	}

	public void setSeatfare(int seatfare) {
		this.seatfare = seatfare;
	}

	public Halls getHalls() {
		return halls;
	}

	public void setHalls(Halls halls) {
		this.halls = halls;
	}

}
