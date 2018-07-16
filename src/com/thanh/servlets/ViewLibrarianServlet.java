package com.thanh.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thanh.beans.Librarian;
import com.thanh.dao.LibrarianDao;

@WebServlet("/viewLibrarian")
public class ViewLibrarianServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection connection = (Connection) getServletContext().getAttribute("DBConnection");
		ArrayList<Librarian> librarians = LibrarianDao.getAllLibrarians(connection);
		
		req.setAttribute("librarians", librarians);
		req.getRequestDispatcher("/jsp/viewLibrarian.jsp").forward(req, resp);
	}
}
