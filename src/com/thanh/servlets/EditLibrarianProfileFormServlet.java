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

@WebServlet("/editLibrarianProfileForm")
public class EditLibrarianProfileFormServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection connection = (Connection) getServletContext().getAttribute("DBConnection");
		int id = Integer.parseInt(req.getParameter("id"));
		
		Librarian librarian = LibrarianDao.getLibrarianById(id, connection);
		req.setAttribute("librarian", librarian);
		
		req.getRequestDispatcher("/jsp/editLibrarianProfileForm.jsp").forward(req, resp);
	}
}
