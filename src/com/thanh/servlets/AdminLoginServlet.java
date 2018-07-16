package com.thanh.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/adminLogin")
public class AdminLoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("adminEmail").trim();
		String password = req.getParameter("adminPassword");
		
		if(email.equals("admin@jtp.com") && password.equals("admin123")) {
			req.getSession().setAttribute("userType", "admin");
			req.getSession().setAttribute("username", email);
			req.getRequestDispatcher("/jsp/adminHome.jsp").forward(req, resp);
		}
		else {
			req.getRequestDispatcher("/jsp/index.jsp").forward(req, resp);
		}
	}
}
