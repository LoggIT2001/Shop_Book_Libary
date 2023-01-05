package com.loggit.LibraryManagement.Entity;

public class DetailOrder {
	private int id;
	private int id_user;
	private int id_order;
	private Book book;
	private int quantity;
	private float total_price;
	public DetailOrder() {
		super();
	}
	public DetailOrder(int id, int id_user, int id_order, Book book, int quantity, float total_price) {
		super();
		this.id = id;
		this.id_user = id_user;
		this.id_order = id_order;
		this.book = book;
		this.quantity = quantity;
		this.total_price = total_price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_order() {
		return id_order;
	}
	public void setId_order(int id_order) {
		this.id_order = id_order;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getTotal_price() {
		return total_price;
	}
	public void setTotal_price(float total_price) {
		this.total_price = total_price;
	}
	@Override
	public String toString() {
		return "DetailOrder [id=" + id + ", id_user=" + id_user + ", id_order=" + id_order + ", book=" + book + ", quantity="
				+ quantity + ", total_price=" + total_price + "]";
	}

	
	
}
