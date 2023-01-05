package com.loggit.LibraryManagement.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.loggit.LibraryManagement.Context.Context;
import com.loggit.LibraryManagement.Entity.*;

public class UserDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public void inserUser(User user) {
		String query="INSERT INTO user(username, pass, fullname, email, phone, role) VALUES (?, ?, ?, ?, ?, ?)";
		int result = 0;
		try {
			conn = Context.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPass());
			ps.setString(1, user.getFullname());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getPhone());
			ps.setInt(5, user.getRole());
			result = ps.executeUpdate();
			
			ps.close();
			conn.close();
			
		} catch (Exception e) {
		}		
	}
	public User getUserByUsername(String username) {
		String query="SELECT * FROM user WHERE username=?";
		User user = new User();
		try {
			conn = Context.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			rs = ps.executeQuery();
			while(rs.next()) {
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPass(rs.getString("pass"));
				user.setFullname(rs.getString("fullname"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setRole(rs.getInt("role"));
			}
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
