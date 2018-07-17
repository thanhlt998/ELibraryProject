package com.thanh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.thanh.beans.Librarian;

public class LibrarianDao {
	public static boolean addLibrarian(Librarian librarian, Connection connection) {
		String sql = "insert into e_librarian value (?,?,?,?,?,?)";
		int rowsAffected = 0;
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, librarian.getId());
			statement.setString(2, librarian.getUsername());
			statement.setString(3, librarian.getName());
			statement.setString(4, librarian.getPassword());
			statement.setString(5, librarian.getEmail());
			statement.setString(6, librarian.getMobile());
			
			rowsAffected = statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("There are something wrong while adding a librarian!!!");
			e.printStackTrace();
		}
		
		return rowsAffected != 0;
	}
	
	public static boolean deleteLibrarianByID(int id, Connection connection) {
		String sql = "delete from e_librarian where id = " + id;
		int rowsAffected = 0;
		try {
			Statement statement = connection.createStatement();
			rowsAffected = statement.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("There are something wrong while deleting librarian!!!");
			e.printStackTrace();
		}
		return rowsAffected != 0;
	}
	
	public static boolean deleteLibrarianByIDList(String[] id, Connection connection) {
		int rowsAffected = 0;
		StringBuffer sql = new StringBuffer("delete from e_librarian where id in (");
		
		int i = 0;
		for(; i < id.length - 1; i++) {
			sql.append(id[i] + ",");
		}
		sql.append(id[i] + ")");
		
		try {
			Statement statement = connection.createStatement();
			rowsAffected = statement.executeUpdate(sql.toString());
		} catch (SQLException e) {
			System.out.println("There are something wrong while delete a list of librarians!!!");
			e.printStackTrace();
		}
		return rowsAffected != 0;
	}
	
	public static boolean updateLibrarian(Librarian librarian, Connection connection) {
		String sql = "update e_librarian set name = ?, password = ?, email = ?, mobile = ? where username = ?";
		int rowsAffected = 0;
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, librarian.getName());
			statement.setString(2, librarian.getPassword());
			statement.setString(3, librarian.getEmail());
			statement.setString(4, librarian.getMobile());
			statement.setString(5, librarian.getUsername());
			
			rowsAffected = statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("There are something wrong while updating librarian info!!!");
			e.printStackTrace();
		}
		return rowsAffected != 0;
	}
	
	public static Librarian getLibrarianById(int id, Connection connection) {
		String sql = "select * from e_librarian where id = " + id;
		Librarian librarian = null;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			if(resultSet.next()) {
				librarian = new Librarian(resultSet);
			}
		} catch (SQLException e) {
			System.out.println("There are something wrong while getting librarian by id!!!");
			e.printStackTrace();
		}
		return librarian;
	}
	
	public static ArrayList<Librarian> getAllLibrarians(Connection connection){
		String sql = "select * from e_librarian";
		ArrayList<Librarian> librarians = new ArrayList<>();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				librarians.add(new Librarian(resultSet));
			}
		} catch (SQLException e) {
			System.out.println("There are something wrong while getting all librarians!!!");
			e.printStackTrace();
		}
		return librarians;
	}
	
	public static boolean authenticateLibrarian(String username, String password, Connection connection) {
		String sql = "select * from e_librarian where username = '" + username + "' and password = '" + password + "'";
		boolean flag = false;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			if(resultSet.next()) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	public static int generateId(Connection connection) {
		String sql = "select max(id) as maxId from e_librarian";
		int maxId = 0;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			if(resultSet.next()) {
				maxId = resultSet.getInt("maxId") + 1;
			}
		} catch (SQLException e) {
			System.out.println("There are something wrong while generating id.");
			e.printStackTrace();
		}
		return maxId;
	}
}
