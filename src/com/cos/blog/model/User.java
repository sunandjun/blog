package com.cos.blog.model;

import java.sql.Timestamp;

public class User {
	private int id;
	private String username;
	private String password;
	private String email;
	private String address;
	private Timestamp createDate;
	
	//쓸까?
	public User(int id, String username, String password, String email, String address, Timestamp createDate) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.address = address;
		this.createDate = createDate;
	}
	//회원가입용
	public User(String username, String password, String email, String address) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.address = address;
	}
	//로그인용
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	//로그인proc 용
	public User(int id, String username, String email, String address) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.address = address;
	}
	//회원정보 읽기
	public User(int id, String username, String password, String email, String address) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.address = address;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	
	
}
