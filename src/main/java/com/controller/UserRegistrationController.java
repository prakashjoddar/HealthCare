package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connection.ConnectionProvider;
import com.dao.CityDAO;
import com.dao.UserDetailsDAO;
import com.dao.jdbcdao.JDBCCityDAO;
import com.dao.jdbcdao.JDBCUserDetailsDAO;
import com.model.City;
import com.model.UserDetails;


public class UserRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserRegistrationController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection connection = null;

		try {
			String firstName = request.getParameter("firstname");
			String lastName = request.getParameter("lastname");
			String address = request.getParameter("address");
			String contact = request.getParameter("contact");
			String email = request.getParameter("email");
			String gender = request.getParameter("gender");
			String stateid = request.getParameter("stateid");
			String cityid = request.getParameter("cityid");
			String dob = request.getParameter("dob");
			String isAdmin = request.getParameter("isadmin");
			String userid = request.getParameter("userid");
			String password = request.getParameter("password");

			String fullName = firstName + " " + lastName;

			UserDetails userDetails = new UserDetails();
			userDetails.setFirstName(firstName);
			userDetails.setLastName(lastName);
			userDetails.setFullName(fullName);
			userDetails.setAddress(address);
			userDetails.setContact(contact);
			userDetails.setEmail(email);
			userDetails.setGender(gender);
			userDetails.setStateId(Integer.parseInt(stateid));
			userDetails.setCityId(Integer.parseInt(cityid));
			userDetails.setDob(dob);
			userDetails.setIsAdmin(isAdmin == "yes" ? 1 : 0);
			userDetails.setUserId(userid);
			userDetails.setPassword(password);

			LocalDateTime dateTime = LocalDateTime.now();
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			String currentDateTime = dateTime.format(format);

			userDetails.setRegDate(currentDateTime);
			userDetails.setLastModified(currentDateTime);


			connection = ConnectionProvider.getConnection();
			UserDetailsDAO userDetailsDAO = new JDBCUserDetailsDAO(connection);
			int status = userDetailsDAO.saveUserDetails(userDetails);

			if (status == 1) {
				status = userDetailsDAO.saveUserCreds(userid, password);

				if (status == 1) {
					System.out.println("Creds Inserted");
					RequestDispatcher rd = request.getRequestDispatcher("/pages/login.jsp");
					rd.include(request, response);
				}
			} else {
				PrintWriter out = response.getWriter();
				out.append("<b>Failed to register, Please try again after sometime...</b>");
				RequestDispatcher rd = request.getRequestDispatcher("/user-register");				
				rd.include(request, response);
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
