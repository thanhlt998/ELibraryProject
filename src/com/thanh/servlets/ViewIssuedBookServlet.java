package com.thanh.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thanh.beans.IssuedBook;
import com.thanh.dao.IssuedBookDao;

@WebServlet("/viewIssuedBook")
public class ViewIssuedBookServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection connection = (Connection) getServletContext().getAttribute("DBConnection");
		
		ArrayList<IssuedBook> issuedBooks = IssuedBookDao.getAllIssuedBooks(connection);
		
		req.setAttribute("issuedBooks", issuedBooks);
		req.getRequestDispatcher("/jsp/viewIssuedBook.jsp").forward(req, resp);
	}
}
