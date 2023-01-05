package com.loggit.LibraryManagement.Entity;

import java.sql.Date;

public class Order {
	private int id;
	private int id_user;
	private Date date;
	private int quantity;
	private float totalprice;
	private String status;
	private String address;
	public Order() {
		super();
	}
	public Order(int id, int id_user, Date date, int quantity, float totalprice, String status, String address) {
		super();
		this.id = id;
		this.id_user = id_user;
		this.date = date;
		this.quantity = quantity;
		this.totalprice = totalprice;
		this.status = status;
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(float totalprice) {
		this.totalprice = totalprice;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", id_user=" + id_user + ", date=" + date + ", quantity=" + quantity
				+ ", totalprice=" + totalprice + ", status=" + status + ", address=" + address + "]";
	}
	
	
}
