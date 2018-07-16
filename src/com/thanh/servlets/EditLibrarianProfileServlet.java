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

@WebServlet("/editLibrarianProfile")
public class EditLibrarianProfileServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection connection = (Connection) getServletContext().getAttribute("DBConnection");
		
		int id = Integer.parseInt(req.getParameter("id"));
		String username = req.getParameter("username");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String mobile = req.getParameter("mobile");
		
		Librarian librarian = new Librarian(id, username, name, password, email, mobile);
		boolean flag = LibrarianDao.updateLibrarian(librarian, connection);
		req.setAttribute("librarian", librarian);
		
		if(flag) {
			req.setAttribute("editLibrarianProfileMessage", "Update profile successfully!!!");
		}
		else {
			req.setAttribute("editLibrarianProfileMessage", "Failed to update profile!!!");
		}
		
		req.getRequestDispatcher("/jsp/editLibrarianProfileForm.jsp").forward(req, resp);
	}
}
