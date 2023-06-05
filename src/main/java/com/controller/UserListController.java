package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connection.ConnectionProvider;
import com.dao.UserDetailsDAO;
import com.dao.jdbcdao.JDBCUserDetailsDAO;
import com.model.UserDetails;

public class UserListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Connection connection = ConnectionProvider.getConnection();
			UserDetailsDAO userDetailsDAO = new JDBCUserDetailsDAO(connection);
			List<UserDetails> userList = userDetailsDAO.getUserDetailsList();

			request.setAttribute("userlist", userList);

			RequestDispatcher rd = request.getRequestDispatcher("pages/users.jsp");
			rd.include(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
