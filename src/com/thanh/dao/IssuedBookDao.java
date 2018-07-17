package com.thanh.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.thanh.beans.IssuedBook;

public class IssuedBookDao {
	
	public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	public static boolean addIssuedBook(IssuedBook issuedBook, Connection connection) {
		boolean status = BookDao.checkIssued(issuedBook.getCallNo(), connection);
		boolean flag = false;
		if(status) {
			String sql = "insert into e_issuebook value (?,?,?,?,?,?)";
			try {
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, issuedBook.getCallNo());
				statement.setString(2, issuedBook.getStudentId());
				statement.setString(3, issuedBook.getStudentName());
				statement.setString(4, issuedBook.getStudentMobile());
				
				java.util.Date date = issuedBook.getIssuedDate();
				java.sql.Date sqlDate = new Date(date.getTime());
				
				statement.setDate(5, sqlDate);
				statement.setString(6, issuedBook.getReturnStatus());
				
				int rowsAffected = statement.executeUpdate();
				
				flag = rowsAffected != 0;
				
				if(flag) {
					BookDao.issueBook(issuedBook.getCallNo(), connection);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}

	public static boolean returnBook(String callNo, String studentId, Connection connection) {
		String sql = "update e_issuebook set returnStatus = 'Yes' where callNo = '" + callNo + "' and studentId = '" + studentId + "'";
		int rowsAffected = 0;
		try {
			Statement statement = connection.createStatement();
			rowsAffected = statement.executeUpdate(sql);
			
			if(rowsAffected != 0) {
				BookDao.returnBook(callNo, connection);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rowsAffected != 0;
	}

	public static ArrayList<IssuedBook> getAllIssuedBooks(Connection connection) {
		ArrayList<IssuedBook> issuedBooks = new ArrayList<>();
		String sql = "select * from e_issuebook";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
				issuedBooks.add(new IssuedBook(resultSet));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return issuedBooks;
	}
}
