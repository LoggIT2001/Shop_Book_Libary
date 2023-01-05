package com.loggit.LibraryManagement.Entity;

public class User {
	private int id;
	private String username;
	private String pass;
	private String fullname;
	private String email;
	private String phone;
	private int role;
	
	public User() {
		super();
	}

	public User(int id, String username, String pass) {
		super();
		this.id = id;
		this.username = username;
		this.pass = pass;
	}
	
	public User(int id, String username, String pass, String fullname, String email, String phone, int role) {
		super();
		this.id = id;
		this.username = username;
		this.pass = pass;
		this.fullname = fullname;
		this.email = email;
		this.phone = phone;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", pass=" + pass + ", fullname=" + fullname + ", email=" + email + ", phone=" + phone + ", role=" + role + "]";
	}
		
}
