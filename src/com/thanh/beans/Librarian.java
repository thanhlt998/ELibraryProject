package com.thanh.beans;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Librarian {
	private int id;
	private String username;
	private String name;
	private String password;
	private String email;
	private String mobile;


	public Librarian(int id, String username, String name, String password, String email, String mobile) {
		super();
		this.id = id;
		this.username = username;
		this.name = name;
		this.password = password;
		this.email = email;
		this.mobile = mobile;
	}

	public Librarian(ResultSet resultSet) throws SQLException {
		this.id = resultSet.getInt("id");
		this.username = resultSet.getString("username");
		this.name = resultSet.getString("name");
		this.password = resultSet.getString("password");
		this.email = resultSet.getString("email");
		this.mobile = resultSet.getString("mobile");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
