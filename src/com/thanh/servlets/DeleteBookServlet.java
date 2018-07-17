package com.thanh.servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thanh.dao.BookDao;

@WebServlet("/deleteBook")
public class DeleteBookServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection connection = (Connection) getServletContext().getAttribute("DBConnection");
		String[] callNo = req.getParameterValues("callNo");
		
		boolean flag = BookDao.deleteBookByCallNoList(callNo, connection);
		
		if(flag) {
			req.setAttribute("deleteBookMessage", "Delete a list of books successfully!!!");
		}
		else {
			req.setAttribute("deleteBookMessage", "Fail to delete a list of books!!!");
		}
		
		resp.sendRedirect("viewBook");
	}
}
