package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connection.ConnectionProvider;
import com.dao.CityDAO;
import com.dao.StateDAO;
import com.dao.jdbcdao.JDBCCityDAO;
import com.dao.jdbcdao.JDBCStateDAO;
import com.model.City;
import com.model.State;

/**
 * Servlet implementation class RegistrationFormController
 */
//@WebServlet("/RegistrationFormController")
public class RegistrationFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegistrationFormController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection connection = null;

		try {
			connection = ConnectionProvider.getConnection();
			
			CityDAO cityDAO = new JDBCCityDAO(connection);
			ArrayList<City> cities = cityDAO.getCityList();
			request.setAttribute("cities", cities);
			
			StateDAO stateDAO = new JDBCStateDAO(connection);
			ArrayList<State> states = stateDAO.getStateList();
			request.setAttribute("states", states);

			RequestDispatcher dispatcher = request.getRequestDispatcher("pages/registration.jsp");
			dispatcher.include(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
