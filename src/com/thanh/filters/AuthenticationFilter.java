package com.thanh.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AuthenticationFilter implements Filter{

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		if(request.getRequestURI().startsWith("/ELibraryProject/home") ||
				request.getRequestURI().startsWith("/ELibraryProject/viewLibrarian") ||
				request.getRequestURI().startsWith("/ELibraryProject/addLibrarianForm") ||
				request.getRequestURI().startsWith("/ELibraryProject/addBookForm") ||
				request.getRequestURI().startsWith("/ELibraryProject/viewBook") ||
				request.getRequestURI().startsWith("/ELibraryProject/issueBookForm") ||
				request.getRequestURI().startsWith("/ELibraryProject/viewIssuedBook") ||
				request.getRequestURI().startsWith("/ELibraryProject/returnBookForm") ||
				request.getRequestURI().startsWith("/ELibraryProject/home")) {
			HttpSession session = request.getSession();
			if(session.getAttribute("userType") == null) {
				request.getRequestDispatcher("/jsp/index.jsp").forward(request, arg1);
			}
		}
		arg2.doFilter(request, arg1);
	}

}
