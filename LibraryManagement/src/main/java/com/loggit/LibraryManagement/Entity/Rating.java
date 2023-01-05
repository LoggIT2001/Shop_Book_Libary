package com.loggit.LibraryManagement.Entity;

public class Rating {
	private int id;
	private String user;
	private int id_book;
	private int star;
	private String cmt;
	
	public Rating() {
		super();
	}

	public Rating(int id, String user, int id_book, int star, String cmt) {
		super();
		this.id = id;
		this.user = user;
		this.id_book = id_book;
		this.star = star;
		this.cmt = cmt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getId_book() {
		return id_book;
	}

	public void setId_book(int id_book) {
		this.id_book = id_book;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public String getCmt() {
		return cmt;
	}

	public void setCmt(String cmt) {
		this.cmt = cmt;
	}

	@Override
	public String toString() {
		return "Rating [id=" + id + ", user=" + user + ", id_book=" + id_book + ", star=" + star + ", cmt=" + cmt
				+ "]";
	}
	
	
}
