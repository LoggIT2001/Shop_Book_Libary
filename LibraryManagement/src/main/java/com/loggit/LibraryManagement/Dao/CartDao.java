package com.loggit.LibraryManagement.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import com.loggit.LibraryManagement.Context.Context;
import com.loggit.LibraryManagement.Entity.*;

public class CartDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public List<Cart> allCartByU(int id){
		List<Cart> li = new ArrayList<Cart>();
		String query = "SELECT * FROM librarymanagement.cart WHERE id_user = ?";
		try {
			conn = Context.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				int id_c = rs.getInt("id");
				int id_book = rs.getInt("id_book");
				int id_user = rs.getInt("id_user");
				int quantity = rs.getInt("quantity");
				BookDao bd = new BookDao();
				Book b = bd.getBookById(id_book);
				li.add(new Cart(id_c, b, id_user, quantity));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return li;
	}
	
	public void addCart(int id_book, int id_user) {
		String query = "INSERT INTO librarymanagement.cart(id_book, id_user, quantity) VALUES(?,?,?)";
		int res = 0;
		try {
			conn = Context.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id_book);
			ps.setInt(2, id_user);
			ps.setInt(3, 1);
			res = ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void addtoCart(int id_book, int id_user, int quantity) {
		String query = "INSERT INTO librarymanagement.cart(id_book, id_user, quantity) VALUES(?,?,?)";
		int res = 0;
		try {
			conn = Context.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id_book);
			ps.setInt(2, id_user);
			ps.setInt(3, quantity);
			res = ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void deleteCart(int id_user) {
		String query = "DELETE FROM librarymanagement.cart WHERE id_user=?";
		int res = 0;
		try {
			conn = Context.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id_user);
			res = ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void deteleCartByB(int id_book, int id_user) {
		String query = "DELETE FROM librarymanagement.cart WHERE id_book=? AND id_user=?";
		int res = 0;
		try {
			conn = Context.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id_book);
			ps.setInt(2, id_user);
			res = ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
