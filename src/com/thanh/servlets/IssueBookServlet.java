package com.thanh.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thanh.beans.IssuedBook;
import com.thanh.dao.IssuedBookDao;

@WebServlet("/issueBook")
public class IssueBookServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection connection = (Connection) getServletContext().getAttribute("DBConnection");
		
		String callNo = req.getParameter("callNo");
		String studentId = req.getParameter("studentId");
		String studentName = req.getParameter("studentName");
		String studentMobile = req.getParameter("studentMobile");
		
		Calendar calendar = Calendar.getInstance();
		Date issuedDate = calendar.getTime();
		
		IssuedBook issuedBook = new IssuedBook(callNo, studentId, studentName, studentMobile, issuedDate, "No");
		
		boolean flag = IssuedBookDao.addIssuedBook(issuedBook, connection);
		
		if(flag) {
			req.setAttribute("issueBookMessage", "Issue a book successfully!!!");
		}
		else {
			req.setAttribute("issueBookMessage", "Fail to issue a book!!!");
		}
		
		req.getRequestDispatcher("/jsp/issueBookForm.jsp").forward(req, resp);
	}
}
