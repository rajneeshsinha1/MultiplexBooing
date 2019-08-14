package org.rajneesh.javaproject.model;

public class Users {

	private int userid;
	private String username;
	private String usertype;
	private long mobileno;
	private String emailid;
	private String password;

	public Users() {

	}

	public Users(int userid, String username, String usertype, long mobileno, String emailid, String password) {
		super();
		this.userid = userid;
		this.username = username;
		this.usertype = usertype;
		this.mobileno = mobileno;
		this.emailid = emailid;
		this.password = password;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public long getMobileno() {
		return mobileno;
	}

	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
