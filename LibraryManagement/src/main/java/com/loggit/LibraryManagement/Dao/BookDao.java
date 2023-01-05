package com.loggit.LibraryManagement.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.loggit.LibraryManagement.Entity.*;
import com.loggit.LibraryManagement.Context.*;

public class BookDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public List<Book> getAllBook(){
		String query = "SELECT * FROM librarymanagement.book LEFT JOIN librarymanagement.book_image ON book.id = book_image.id";
		List<Book> li = new ArrayList<Book>();
		try {
			conn = Context.getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String author = rs.getString("author");
				String category = rs.getString("category");
				String description = rs.getString("description");
				Date release_date = rs.getDate("release_date");
				int page = rs.getInt("page");
				float price = rs.getFloat("price");
				String image = rs.getString("image");
				li.add(new Book(id, title, author, category, description, release_date, page, price, image));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return li;
	}
	
	public Book getBookById(int id) {
		String query = "SELECT * FROM librarymanagement.book LEFT JOIN librarymanagement.book_image ON book.id = book_image.id WHERE book.id = ?";
		Book b = new Book();
		try {
			conn = Context.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				int idb = rs.getInt("id");
				String title = rs.getString("title");
				String author = rs.getString("author");
				String category = rs.getString("category");
				String description = rs.getString("description");
				Date release_date = rs.getDate("release_date");
				int page = rs.getInt("page");
				float price = rs.getFloat("price");
				String image = rs.getString("image");
				b = new Book(idb, title, author, category, description, release_date, page, price, image);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return b;
	}
	
	public void insertBook(Book book, MultipartFile file) {
		String query = "INSERT INTO book(title, author, category, description, release_date, page, price ) VALUES(?, ?, ?, ?, ?, ?, ?)";
		String sql = "INSERT INTO book_image(id, image) VALUES(?, ?)";
		int result = 0;
		try {
			Book b = new Book();
			b = book;
			String filename = StringUtils.cleanPath(file.getOriginalFilename());
			if(filename.contains("..")){
				System.out.println("not a a valid file");
			}
			b.setImg(Base64.getEncoder().encodeToString(file.getBytes()));
			conn = Context.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, b.getTitle());
			ps.setString(2, b.getAuthor());
			ps.setString(3, b.getCategory());
			ps.setString(4, b.getDescription());
			ps.setDate(5, new java.sql.Date(b.getRelease_date().getTime()));
			ps.setInt(6, b.getPage());
			ps.setFloat(7, b.getPrice());
			result = ps.executeUpdate();
			// lay id quyen sach vua them
			String sql2 = "SELECT MAX(id) FROM librarymanagement.book";
			PreparedStatement ps2 = conn.prepareStatement(sql2);
			rs = ps2.executeQuery();
			int newId = 0;
			if(rs.next()) {
				newId = rs.getInt(1);
			}
			ps2.close();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, newId);
			ps.setString(2, b.getImg());
			result = ps.executeUpdate();
			
			ps.close();
			conn.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void updateBook(Book book, MultipartFile file) {
		String query = "UPDATE book SET title=?, author=?, category=?, description=?, release_date=?, page=?, price=? WHERE id=?";
		String sql = "UPDATE book_image SET image=? WHERE id=?";
		int result = 0;
		try {
			Book b = new Book();
			b = book;
			String filename = StringUtils.cleanPath(file.getOriginalFilename());
			if(filename.contains("..")){
				System.out.println("not a a valid file");
			}
			b.setImg(Base64.getEncoder().encodeToString(file.getBytes()));
			conn = Context.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, b.getTitle());
			ps.setString(2, b.getAuthor());
			ps.setString(3, b.getCategory());
			ps.setString(4, b.getDescription());
			ps.setDate(5, new java.sql.Date(b.getRelease_date().getTime()));
			ps.setInt(6, b.getPage());
			ps.setFloat(7, b.getPrice());
			ps.setInt(8, b.getId());
			result = ps.executeUpdate();
			// update image book
			ps = conn.prepareStatement(sql);
			ps.setString(1, b.getImg());
			ps.setInt(2, b.getId());
			result = ps.executeUpdate();
			
			ps.close();
			conn.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void deleteBook(int id) {
		String query = "DELETE FROM book WHERE id=?";
		String sql = "DELETE FROM book_image WHERE id = ?";
		int result = 0;
		try {
			conn = Context.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			result = ps.executeUpdate();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			result = ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public List<Book> getBookByCate(String cate){
		List<Book> li = new ArrayList<Book>();
		String query = "SELECT * FROM librarymanagement.book LEFT JOIN librarymanagement.book_image ON book.id = book_image.id WHERE category = ?";
		
		try {
			conn = Context.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, cate);
			rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String author = rs.getString("author");
				String category = rs.getString("category");
				String description = rs.getString("description");
				Date release_date = rs.getDate("release_date");
				int page = rs.getInt("page");
				float price = rs.getFloat("price");
				String image = rs.getString("image");
				li.add(new Book(id, title, author, category, description, release_date, page, price, image));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return li;
	}
	
	public List<Book> getBookByName(String name){
		List<Book> li = new ArrayList<Book>();
		String query = "SELECT * FROM librarymanagement.book LEFT JOIN librarymanagement.book_image ON book.id = book_image.id WHERE title LIKE ?";
		
		try {
			conn = Context.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, "%" + name + "%");
			rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String author = rs.getString("author");
				String category = rs.getString("category");
				String description = rs.getString("description");
				Date release_date = rs.getDate("release_date");
				int page = rs.getInt("page");
				float price = rs.getFloat("price");
				String image = rs.getString("image");
				li.add(new Book(id, title, author, category, description, release_date, page, price, image));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return li;
	}
}
