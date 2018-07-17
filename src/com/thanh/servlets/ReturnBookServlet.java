package com.thanh.servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thanh.dao.IssuedBookDao;

@WebServlet("/returnBook")
public class ReturnBookServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection connection = (Connection) getServletContext().getAttribute("DBConnection");
		String callNo = req.getParameter("callNo").trim();
		String studentId = req.getParameter("studentId").trim();
		
		boolean flag = IssuedBookDao.returnBook(callNo, studentId, connection);
		
		if(flag) {
			req.setAttribute("returnBookMessage", "Return a book successfully!!!");
		}
		else {
			req.setAttribute("returnBookMessage", "Fail to return a book!!!");
		}
		
		req.getRequestDispatcher("/jsp/returnBookForm.jsp").forward(req, resp);
	}
}
