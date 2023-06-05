package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.core.ApplicationContext;

import com.connection.ConnectionProvider;
import com.dao.UserDetailsDAO;
import com.dao.jdbcdao.JDBCCityDAO;
import com.dao.jdbcdao.JDBCStateDAO;
import com.dao.jdbcdao.JDBCUserDetailsDAO;
import com.model.UserDetails;
import com.mysql.cj.Session;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection connection = null;

		try {
			connection = ConnectionProvider.getConnection();
			UserDetailsDAO userDetailsDAO = new JDBCUserDetailsDAO(connection);

			String username = request.getParameter("username");
			String password = request.getParameter("password");
			boolean isUserExist = userDetailsDAO.checkUserCreds(username, password);

			
			if (!isUserExist) {
				PrintWriter out = response.getWriter();
				out.append("<b>Wrong UserId or password<b>");

				RequestDispatcher rd = request.getRequestDispatcher("pages/login.jsp");
				rd.forward(request, response);
			} else {
				// ServletContext appContext = getServletContext();
				HttpSession session = request.getSession(true);
				session.setAttribute("username", username);				

				RequestDispatcher rd = request.getRequestDispatcher("/users");
				rd.forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
