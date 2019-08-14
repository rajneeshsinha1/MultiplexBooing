package org.rajneesh.javaproject.model;

public class Movies {

	private int movieid;
	private String moviename;
	private String movielanguage;

	public Movies() {

	}

	public Movies(int movieid, String moviename, String movielanguage) {
		this.movieid = movieid;
		this.moviename = moviename;
		this.movielanguage = movielanguage;
	}

	public int getMovieid() {
		return movieid;
	}

	public void setMovieid(int movieid) {
		this.movieid = movieid;
	}

	public String getMoviename() {
		return moviename;
	}

	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}

	public String getMovielanguage() {
		return movielanguage;
	}

	public void setMovielanguage(String movielanguage) {
		this.movielanguage = movielanguage;
	}

}
