package com.loggit.LibraryManagement.Entity;

public class Cart {
	private int id;
	private Book book;
	private int id_user;
	private int quantity;
	
	
	public Cart() {
		super();
	}
	public Cart(int id, Book book, int id_user, int quantity) {
		super();
		this.id = id;
		this.book = book;
		this.id_user = id_user;
		this.quantity = quantity;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	@Override
	public String toString() {
		return "Cart [id=" + id + ", book=" + book + ", id_user=" + id_user + ", quantity" + quantity + "]";
	}
	
	
	
}
