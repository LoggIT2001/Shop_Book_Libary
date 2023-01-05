package com.loggit.LibraryManagement.Entity;

import java.util.Date;

import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class Book {
	private int id;
	@NotBlank(message="Book's Title cannot empty!")
	private String title;
	@NotBlank(message="Book's Author cannot empty!")
	private String author;
	@NotBlank(message="Book's Category cannot empty!")
	private String category;
	
	private String description;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message="Book's Release_date cannot empty!")
	private Date release_date;
	
	@NotNull(message="Book's Page cannot empty!")
	private int page;
	private float price;
	private String img;
	
	public Book() {
		super();
	}

	public Book(int id, String title, String author, String category, String description, Date release_date, int page, float price,String img) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.category = category;
		this.description = description;
		this.release_date = release_date;
		this.page = page;
		this.price = price;
		this.img = img;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getRelease_date() {
		return release_date;
	}

	public void setRelease_date(Date release_date) {
		this.release_date = release_date;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", category=" + category
				+ ", description=" + description + ", release_date=" + release_date + ", page=" + page + ", price=" + price + ", img=" + img
				+ "]";
	}

}
