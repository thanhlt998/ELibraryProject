package com.thanh.beans;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Book {
	private String callNo;
	private String name;
	private String author;
	private String publisher;
	private int quantity;
	private int issuedBook;

	public Book(String callNo, String name, String author, String publisher, int quantity, int issuedBook) {
		super();
		this.callNo = callNo;
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.quantity = quantity;
		this.issuedBook = issuedBook;
	}

	public Book(ResultSet resultSet) throws SQLException {
		this.callNo = resultSet.getString("callNo");
		this.name = resultSet.getString("name");
		this.author = resultSet.getString("author");
		this.publisher = resultSet.getString("publisher");
		this.quantity = resultSet.getInt("quantity");
		this.issuedBook = resultSet.getInt("issued");
	}

	public String getCallNo() {
		return callNo;
	}

	public void setCallNo(String callNo) {
		this.callNo = callNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getIssuedBook() {
		return issuedBook;
	}

	public void setIssuedBook(int issuedBook) {
		this.issuedBook = issuedBook;
	}

}
