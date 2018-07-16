package com.thanh.servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thanh.beans.Librarian;
import com.thanh.dao.LibrarianDao;

@WebServlet("/addLibrarian")
public class AddLibrarianServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection connection = (Connection) getServletContext().getAttribute("DBConnection");
		int id = LibrarianDao.generateId(connection);
		String username = req.getParameter("username").trim();
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String mobile = req.getParameter("mobileNumber").trim();
		
		Librarian librarian = new Librarian(id, username, name, password, email, mobile);
		
		boolean flag = LibrarianDao.addLibrarian(librarian, connection);
		
		if(flag) {
			req.setAttribute("addLibrarianMessage", "Add a librarian successfully!!!");
		}
		else {
			req.setAttribute("addLibrarianMessage", "Failed to add a librarian, please try again!!!");
		}
		
		req.getRequestDispatcher("/jsp/addLibrarianForm.jsp").forward(req, resp);
	}
}
