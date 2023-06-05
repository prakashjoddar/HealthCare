package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connection.ConnectionProvider;
import com.dao.UserDetailsDAO;
import com.dao.jdbcdao.JDBCUserDetailsDAO;
import com.model.UserDetails;

public class UpdateUserDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		UserDetails details = new UserDetails(Integer.parseInt(request.getParameter("id")),
				request.getParameter("firstname"), request.getParameter("lastname"), request.getParameter("address"),
				request.getParameter("contact"), request.getParameter("gender"),
				Integer.parseInt(request.getParameter("stateid")), Integer.parseInt(request.getParameter("cityid")),
				request.getParameter("email"), request.getParameter("dob"),
				Integer.parseInt(request.getParameter("isadmin")));

		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String currentDateTime = dateTime.format(format);

		details.setLastModified(currentDateTime);

		try {
			UserDetailsDAO userDetailsDAO = new JDBCUserDetailsDAO(ConnectionProvider.getConnection());
			int result = userDetailsDAO.updateUserDetails(details);
			
			if (result == 1) {
				RequestDispatcher rd = request.getRequestDispatcher("/users");
				rd.include(request, response);

				PrintWriter pw = response.getWriter();
				pw.print("<h3>User ID : " + request.getParameter("id") + " - Succesfully Updated<h3>");
			}else {
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
