package com.thanh.servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thanh.dao.LibrarianDao;

@WebServlet("/deleteLibrarian")
public class DeleteLibrarianServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection connection = (Connection) getServletContext().getAttribute("DBConnection");
		String[] id = req.getParameterValues("id");
		
		boolean flag = LibrarianDao.deleteLibrarianByIDList(id, connection);
		
		if(flag) {
			req.setAttribute("deleteLibrarianMessage", "Delete librarian list successfully!!!");
		}
		else {
			req.setAttribute("deleteLibrarianMessage", "Failed to delete librarian list");
		}
		
		resp.sendRedirect("viewLibrarian");
	}
}
