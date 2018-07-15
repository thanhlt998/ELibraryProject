package com.thanh.listeners;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.thanh.dao.DBConnection;

public class ApplicationListener implements ServletContextListener {
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		Connection connection = DBConnection.getConnectionToDB();
		
		sce.getServletContext().setAttribute("DBConnection", connection);
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		Connection connection = (Connection) sce.getServletContext().getAttribute("DBConnection");
		
		try {
			connection.close();
			System.out.println("Close connection successfully!!!");
		} catch (SQLException e) {
			System.out.println("Failed to close connection, there are something wrong here!!!);
			e.printStackTrace();
		}
	}
}
