package com.loggit.LibraryManagement.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.loggit.LibraryManagement.Context.Context;
import com.loggit.LibraryManagement.Entity.*;

public class CategoryDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public List<Category> getAllCategory(){
		List<Category> li = new ArrayList<Category>();
		String query = "SELECT * FROM book_category";
		
		try {
			conn = Context.getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String category = rs.getString("category");
				li.add(new Category(id, category));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return li;
	}
	
	
}
