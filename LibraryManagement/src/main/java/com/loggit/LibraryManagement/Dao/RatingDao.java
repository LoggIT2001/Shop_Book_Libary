package com.loggit.LibraryManagement.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.loggit.LibraryManagement.Context.Context;
import com.loggit.LibraryManagement.Entity.Rating;

public class RatingDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public List<Rating> rating(String id_bo){
		List<Rating> li = new ArrayList<Rating>();
		String query = "SELECT * FROM librarymanagement.rating WHERE id_book=?";
		try {
			conn = Context.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, Integer.parseInt(id_bo));
			rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				int id_book = rs.getInt("id_book");
				String user = rs.getString("user");				
				int star = rs.getInt("star");
				String cmt = rs.getString("cmt");
				li.add(new Rating(id, user, id_book, star, cmt));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return li;
	}
	public void voting(int id_book, String user, int star, String cmt) {
		String query = "INSERT INTO librarymanagement.rating(id_book, user, star, cmt) VALUES(?, ?, ?, ?)";
		int res = 0;
		try {
			conn = Context.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id_book);
			ps.setString(2, user);
			ps.setInt(3, star);
			ps.setString(4, cmt);
			res = ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
