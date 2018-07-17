package com.thanh.servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thanh.beans.Book;
import com.thanh.dao.BookDao;

@WebServlet("/addBook")
public class AddBookServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection connection = (Connection) getServletContext().getAttribute("DBConnection");
		
		String callNo = req.getParameter("callno");
		String name = req.getParameter("name");
		String author = req.getParameter("author");
		String publisher = req.getParameter("publisher");
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		
		Book book = new Book(callNo, name, author, publisher, quantity, 0);
		
		boolean flag = BookDao.addBook(book, connection);
		
		if(flag) {
			req.setAttribute("addBookMessage", "Add a book successfully!!!");
		}
		else {
			req.setAttribute("addBookMessage", "Fail to add a book!!!");
		}
		
		req.getRequestDispatcher("/jsp/addBookForm.jsp").forward(req, resp);
	}
}
