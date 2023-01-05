package com.loggit.LibraryManagement.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.loggit.LibraryManagement.Entity.*;
import com.loggit.LibraryManagement.Context.*;

public class OrderDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public List<Order> getAllOrder(int id_user){
		List<Order> li = new ArrayList<Order>();
		String query = "SELECT * FROM librarymanagement.order WHERE id_user = ?";
		
		try {
			conn = Context.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id_user);
			rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				int id_u = rs.getInt("id_user");
				Date date = rs.getDate("date");
				int quantity = rs.getInt("quantity");
				float totalprice = rs.getFloat("total_price");
				String status = rs.getString("status");
				String address = rs.getString("address");
				li.add(new Order(id, id_u, date, quantity, totalprice, status, address));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return li;
	}
	
	public List<Order> getAllOrderAd(){
		List<Order> li = new ArrayList<Order>();
		String query = "SELECT * FROM librarymanagement.order";
		
		try {
			conn = Context.getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				int id_u = rs.getInt("id_user");
				Date date = rs.getDate("date");
				int quantity = rs.getInt("quantity");
				float totalprice = rs.getFloat("total_price");
				String status = rs.getString("status");
				String address = rs.getString("address");
				li.add(new Order(id, id_u, date, quantity, totalprice, status, address));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return li;
	}
	
	public Order getOrder(int id) {
		String query = "SELECT * FROM librarymanagement.order WHERE id = ?";
		Order o = new Order();
		try {
			conn = Context.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				int id_o = rs.getInt("id");
				int id_u = rs.getInt("id_user");
				Date date = rs.getDate("date");
				int quantity = rs.getInt("quantity");
				float totalprice = rs.getFloat("total_price");
				String status = rs.getString("status");
				String address = rs.getString("address");
				o = new Order(id_o, id_u, date, quantity, totalprice, status, address);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return o;
	}
	
	public int idOrderMax() {
		String query = "SELECT MAX(id) FROM librarymanagement.order";
		int newId = 0;
		try {
			conn = Context.getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				newId = rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return newId;
	}
	
	public void insertOrder(int id_user, Date date, int quantity, float total_price, String status, String address) {
		String query = "INSERT INTO librarymanagement.order(id_user, date, quantity, total_price, status, address) VALUES(?, ?, ?, ?, ?, ?)";
		int res = 0;
		
		try {
			conn = Context.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id_user);
			ps.setDate(2, new java.sql.Date(date.getTime()));
			ps.setInt(3, quantity);
			ps.setFloat(4, total_price);
			ps.setString(5, status);
			ps.setString(6, address);
			res = ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void deleteOrder(int id) {
		String query = "DELETE FROM librarymanagement.order WHERE id=?";
		int res=0;
		try {
			conn = Context.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			res = ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public List<DetailOrder> getAllDetailOrder(int id_o){
		List<DetailOrder> li = new ArrayList<DetailOrder>();
		String query = "SELECT * FROM librarymanagement.detailorder WHERE id_order = ?;";
		
		try {
			conn = Context.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id_o);
			rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				int id_order = rs.getInt("id_order");
				int id_book = rs.getInt("id_book");
				int id_user = rs.getInt("id_user");
				int quantity = rs.getInt("quantity");
				float total_price = rs.getFloat("total_price");
				
				BookDao bd = new BookDao();
				Book b = new Book();
				b = bd.getBookById(id_book);
				li.add(new DetailOrder(id, id_user, id_order, b, quantity, total_price));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		for(DetailOrder odo: li) {
			System.out.println(odo);
		}
		return li;
	}
	
	public void insertDetailOrder(int id_order, int id_book, int id_user, int quantity, float total_price) {
		String query = "INSERT INTO librarymanagement.detailorder(id_order, id_book, id_user, quantity, total_price) VALUES(?, ?, ?, ?, ?)";
		int res = 0;
		
		try {
			conn = Context.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id_order);
			ps.setInt(2, id_book);
			ps.setInt(3, id_user);
			ps.setInt(4, quantity);
			ps.setFloat(5, total_price);
			res = ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void deleteDetailOrder(int id_o) {
		String query = "DELETE FROM librarymanagement.detailorder WHERE id_order=?";
		int res=0;
		try {
			conn = Context.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id_o);
			res = ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void updateOrder(int id, String status) {
		String query = "UPDATE librarymanagement.order SET status=? WHERE id=?;";
		int res=0;
		
		try {
			conn = Context.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, status);
			ps.setInt(2, id);
			res = ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
