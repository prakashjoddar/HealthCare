package com.controller;

import java.io.IOException;
import java.sql.Connection;
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
import com.dao.UserDetailsDAO;
import com.dao.jdbcdao.JDBCCityDAO;
import com.dao.jdbcdao.JDBCStateDAO;
import com.dao.jdbcdao.JDBCUserDetailsDAO;
import com.model.City;
import com.model.State;
import com.model.UserDetails;

//@WebServlet("/UserDetailsController")
public class UserDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserDetailsController() {
	
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try (Connection connection = ConnectionProvider.getConnection();){			
			
			UserDetailsDAO userDetailsDAO = new JDBCUserDetailsDAO(connection);
			int id = Integer.parseInt(req.getParameter("id"));
			UserDetails userDetails = userDetailsDAO.findUserById(id);
			req.setAttribute("userdetails", userDetails);
			
			CityDAO cityDAO = new JDBCCityDAO(connection);
			ArrayList<City> cities = cityDAO.getCityList();
			req.setAttribute("cities", cities);
			
			StateDAO stateDAO = new JDBCStateDAO(connection);
			ArrayList<State> states = stateDAO.getStateList();
			req.setAttribute("states", states);

			
			RequestDispatcher rd = req.getRequestDispatcher("pages/updateUser.jsp");
			rd.include(req, resp);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
