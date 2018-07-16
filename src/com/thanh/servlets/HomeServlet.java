package com.thanh.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String usertype = (String) req.getSession().getAttribute("userType");
		if (usertype != null) {
			if (usertype.equals("admin")) {
				req.getRequestDispatcher("/jsp/adminHome.jsp").forward(req, resp);
			} else if (usertype.equals("librarian")) {
				req.getRequestDispatcher("/jsp/librarianHome.jsp").forward(req, resp);
			}
		}
		else {
			req.getRequestDispatcher("/jsp/index.jsp").forward(req, resp);
		}
	}
}
