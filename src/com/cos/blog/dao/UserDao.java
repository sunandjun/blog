package com.cos.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cos.blog.config.DBConn;
import com.cos.blog.model.User;

public class UserDao {
	public int 회원수정(User user) {
		//username 는 수정이 불가능 항목이기때문에 업데이트를 하지 않는다.
		String sql = "UPDATE user SET password=?,email=?,address=? "
				+ " WHERE id = ? ";
		Connection conn = DBConn.getInstance();
		try {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, user.getPassword());
		pstmt.setString(2, user.getEmail());
		pstmt.setString(3, user.getAddress());
		pstmt.setInt(4, user.getId());
		
		return pstmt.executeUpdate();
		
		}catch (Exception e) {
		// TODO: handle exception
			System.out.println("회원수정 error : " + e.getMessage());
		} 			
		return -1;
	}
	public int 회원가입(User user) {
		String sql = "INSERT INTO user(username,password,email,address,createDate) "
					+ "VALUES (?,?,?,?,NOW()) ";
		Connection conn = DBConn.getInstance();
		try {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, user.getUsername());
		pstmt.setString(2, user.getPassword());
		pstmt.setString(3, user.getEmail());
		pstmt.setString(4, user.getAddress());
		
		return pstmt.executeUpdate();
		
		}catch (Exception e) {
		// TODO: handle exception
			System.out.println("회원가입 error : " + e.getMessage());
		} 			
		return -1;
	}
	
	public User 로그인(User user) {
		String sql = "SELECT id,username,email,address FROM user WHERE username = ? AND password=?";
		Connection conn = DBConn.getInstance();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());

			ResultSet rs =  pstmt.executeQuery();
			if(rs.next()) {
				User userEntity = new User(
									rs.getInt("id"),
									rs.getString("username"),
									rs.getString("email"),
									rs.getString("address")
									);
				return userEntity;
			}
		
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("로그인 error : " + e.getMessage());
		} 		
		
		return null;
	}
	
	public User 회원정보읽기(User user) {
		String sql = "SELECT * FROM user WHERE username = ? AND id=?";
		Connection conn = DBConn.getInstance();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setInt(2, user.getId());

			ResultSet rs =  pstmt.executeQuery();
			if(rs.next()) {
				User userEntity = new User(
									rs.getInt("id"),
									rs.getString("username"),
									rs.getString("password"),
									rs.getString("email"),
									rs.getString("address")
									);
				return userEntity;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("회원정보읽기 error : " + e.getMessage());
		}
		return null;
	}
}
