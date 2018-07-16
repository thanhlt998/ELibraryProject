package com.thanh.servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thanh.dao.LibrarianDao;

@WebServlet("/librarianLogin")
public class LibrarianLogin extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection connection = (Connection) getServletContext().getAttribute("DBConnection");
		String username = req.getParameter("username").trim();
		String password = req.getParameter("password");
		
		boolean validLibrarian = LibrarianDao.authenticateLibrarian(username, password, connection);
		if(validLibrarian) {
			req.getSession().setAttribute("userType", "librarian");
			req.getSession().setAttribute("username", username);
			req.getRequestDispatcher("/jsp/librarianHome.jsp").forward(req, resp);
		}
		else {
			req.getRequestDispatcher("/jsp/index.jsp").forward(req, resp);
		}
	}
}
