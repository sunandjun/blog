package com.cos.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.blog.config.DBConn;
import com.cos.blog.model.Post;
import com.cos.blog.model.User;


/*Post
 * this.id = id;
 * this.title = title;
	this.content = content;
	this.readCount = readCount;
	this.createDate = createDate;
	this.userId = userId;
 * */
public class PostDao {
	
	public int 글쓰기(Post post) {
		String sql = "INSERT INTO post(title,content,readCount,createDate,userId) "
					+ "VALUES (?,?,?,NOW(),?) ";
		Connection conn = DBConn.getInstance();
		try {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, post.getTitle());
		pstmt.setString(2, post.getContent());
		pstmt.setInt(3, post.getReadCount());
		pstmt.setInt(4, post.getUserId());
		
		return pstmt.executeUpdate();
		
		}catch (Exception e) {
		// TODO: handle exception
			System.out.println("글쓰기 error : " + e.getMessage());
		} 			
		return -1;
	}//글쓰기
	
	public List<Post> 글목록(){
		String sql = "SELECT * FROM post";
		
		Connection conn = DBConn.getInstance();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
					
			ResultSet rs = pstmt.executeQuery();
			 
			List<Post> posts = new ArrayList<>();
			while (rs.next()) {
				
				Post post = new Post(
						rs.getInt("id"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getInt("readCount"),
						rs.getTimestamp("createDate"),
						rs.getInt("userId"));				 
				 
				posts.add(post);
			}
			return posts;
		
		}catch (Exception e) {
		// TODO: handle exception
			System.out.println("글목록 error : " + e.getMessage());
		} 			

		return null;
	}//글목록
	
	public Post 상세보기(String postId){
		String sql = "SELECT * FROM post WHERE id =?";
		
		Connection conn = DBConn.getInstance();
		Connection conn2 = DBConn.getInstance();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(postId));
					
			ResultSet rs = pstmt.executeQuery();
			Post post = new Post();
			if(rs.next()) {
				post.setId(rs.getInt("id"));
				post.setTitle(rs.getString("title"));
				post.setContent(rs.getString("content"));
				post.setReadCount(rs.getInt("readCount")+1);
				post.setCreateDate(rs.getTimestamp("createDate"));
				post.setUserId(rs.getInt("userId"));
			}
			
			String readCountSql = "UPDATE post SET readCount=? WHERE id=?";
			PreparedStatement pstmt2 = conn2.prepareStatement(readCountSql);
			pstmt2.setInt(1, rs.getInt("readCount")+1);
			pstmt2.setInt(2, Integer.parseInt(postId));
			int n = pstmt2.executeUpdate();
			System.out.println("1231");
			
			return post;
		
		}catch (Exception e) {
		// TODO: handle exception
			System.out.println("상세보기 error : " + e.getMessage());
		} 			

		return null;
	}//상세보기
	
	public int 글수정(Post post) {
		String sql = "UPDATE post SET title=?,content=?,readCount=?,createDate=now() WHERE id=? AND userId=?";

		Connection conn = DBConn.getInstance();
		try {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, post.getTitle());
		pstmt.setString(2, post.getContent());
		pstmt.setInt(3, post.getReadCount());
		pstmt.setInt(4, post.getId());
		pstmt.setInt(5, post.getUserId());
		
		return pstmt.executeUpdate();
		
		}catch (Exception e) {
		// TODO: handle exception
			System.out.println("글수정 error : " + e.getMessage());
		} 			
		return -1;
	}//글수정
}
