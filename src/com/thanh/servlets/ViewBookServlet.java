package com.thanh.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thanh.beans.Book;
import com.thanh.dao.BookDao;

@WebServlet("/viewBook")
public class ViewBookServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection connection = (Connection) getServletContext().getAttribute("DBConnection");
		ArrayList<Book> books = BookDao.getAllBooks(connection);
		
		req.setAttribute("books", books);
		req.getRequestDispatcher("/jsp/viewBook.jsp").forward(req, resp);
	}
}
