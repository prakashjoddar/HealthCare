package com.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.connection.ConnectionProvider;
import com.dao.CityDAO;
import com.dao.jdbcdao.JDBCCityDAO;
import com.model.City;

public class CityController {
	public int addCity() {

		int status = 0;
		Connection connection = null;

		try {
//			
			int id =1;
			int stateId = 1;
			String name = "Nagpur";

			City apmCity = new City();
			apmCity.setId(id);
			apmCity.setStateId(stateId);
			apmCity.setName(name);

			connection = ConnectionProvider.getConnection();
			CityDAO ampCityDAO = new JDBCCityDAO(connection);
			status = ampCityDAO.saveCityDetails(apmCity);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;

	}

	public void showAllCities() throws SQLException {
		Connection connection = null;

		try {
			connection = ConnectionProvider.getConnection();
			JDBCCityDAO jdbcApmCityDAO = new JDBCCityDAO(connection);
			ArrayList<City> cityList = jdbcApmCityDAO.getCityList();
			for (City city : cityList)
				System.out.println(city.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}
}
