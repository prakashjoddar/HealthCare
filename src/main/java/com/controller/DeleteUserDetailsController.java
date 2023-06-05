package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connection.ConnectionProvider;
import com.dao.UserDetailsDAO;
import com.dao.jdbcdao.JDBCUserDetailsDAO;

@WebServlet("/DeleteUser")
public class DeleteUserDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		try (Connection connection = ConnectionProvider.getConnection(); PrintWriter pw = response.getWriter();) {
			UserDetailsDAO userDetails = new JDBCUserDetailsDAO(connection);
			int result = userDetails.removeUserDetails(id);

			RequestDispatcher rd = request.getRequestDispatcher("/users");
			rd.include(request, response);

			if (result == 1) {
				pw.print("<h3>User ID : " + id + " - Succesfully Deleted<h3>");
			} else {
				pw.print("<h3>Failed to delete - User ID : " + id + "<h3>");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
