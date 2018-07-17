package com.thanh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.thanh.beans.Book;

public class BookDao {

	public static boolean addBook(Book book, Connection connection) {
		String sql = "insert into e_book value (?,?,?,?,?,?)";
		int rowsAffected = 0;
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, book.getCallNo());
			statement.setString(2, book.getName());
			statement.setString(3, book.getAuthor());
			statement.setString(4, book.getPublisher());
			statement.setInt(5, book.getQuantity());
			statement.setInt(6, book.getIssuedBook());

			rowsAffected = statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("There are something wrong when adding a book!!!");
			e.printStackTrace();
		}

		return rowsAffected != 0;
	}

	public static ArrayList<Book> getAllBooks(Connection connection) {
		String sql = "select * from e_book";
		ArrayList<Book> books = new ArrayList<>();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				books.add(new Book(resultSet));
			}
		} catch (SQLException e) {
			System.out.println("There are something wrong when getting all books!!!");
			e.printStackTrace();
		}

		return books;

	}

	public static Book getBookByCallNo(String callNo, Connection connection) {
		Book book = null;
		String sql = "select * from e_book where callNo = '" + callNo + "'";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				book = new Book(resultSet);
			}
		} catch (SQLException e) {
			System.out.println("There are something wrong while getting book by callNo!!!");
			e.printStackTrace();
		}
		return book;
	}

	public static boolean deleteBookByCallNo(String callNo, Connection connection) {
		int rowsAffected = 0;
		String sql = "delete from e_book where callNo='" + callNo + "'";
		try {
			Statement statement = connection.createStatement();
			rowsAffected = statement.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("There are something wrong while delete book by callNo");
			e.printStackTrace();
		}
		return rowsAffected != 0;
	}
	
	public static boolean deleteBookByCallNoList(String[] callNo, Connection connection) {
		int rowsAffected = 0;
		StringBuffer sql = new StringBuffer("delete from e_book where callNo in (");
		
		int i = 0;
		for(; i < callNo.length - 1; i++) {
			sql.append("'" + callNo[i] + "',");
		}
		sql.append("'" + callNo[i] + "')");
		
		try {
			Statement statement = connection.createStatement();
			rowsAffected = statement.executeUpdate(sql.toString());
		} catch (SQLException e) {
			System.out.println("There are something wrong while delete a list of books!!!");
			e.printStackTrace();
		}
		return rowsAffected != 0;
	}

	public static boolean updateBook(Book book, Connection connection) {
		String sql = "update e_book set name=?, author=?, publisher=?, quantity=?, issued=? where callNo=?";
		int rowsAffected = 0;
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, book.getName());
			statement.setString(2, book.getAuthor());
			statement.setString(3, book.getPublisher());
			statement.setInt(4, book.getQuantity());
			statement.setInt(5, book.getIssuedBook());
			statement.setString(6, book.getCallNo());
			
			rowsAffected = statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("There are some thing wrong while updating book info.");
			e.printStackTrace();
		}
		return rowsAffected != 0;
	}

	public static int getIssuedByCallNo(String callNo, Connection connection) {
		String sql = "select issued from e_book where callNo = '" + callNo + "'";
		int issued = 0;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			if(resultSet.next()) {
				issued = resultSet.getInt("issued");
			}
		} catch (SQLException e) {
			System.out.println("There are something wrong while getting issued!!!");
			e.printStackTrace();
		}
		
		return issued;
	}
	
	public static boolean checkIssued(String callNo, Connection connection) {
		boolean status = false;
		String sql = "select * from e_book where callNo = '" + callNo + "' and quantity > issued";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			if(resultSet.next()) {
				status = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	
	public static boolean issueBook(String callNo, Connection connection) {
		int issued = getIssuedByCallNo(callNo, connection) + 1;
		String sql = "update e_book set issued = " + issued + " where callNo = '" + callNo + "'";
		int rowsAffected = 0;
		try {
			Statement statement = connection.createStatement();
			rowsAffected = statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowsAffected != 0;
	}
	
	public static boolean returnBook(String callNo, Connection connection) {
		int issued = getIssuedByCallNo(callNo, connection) - 1;
		String sql = "update e_book set issued = " + issued + " where callNo = '" + callNo + "'";
		int rowsAffected = 0;
		try {
			Statement statement = connection.createStatement();
			rowsAffected = statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowsAffected != 0;
	}
}
