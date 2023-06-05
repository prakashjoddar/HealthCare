package com.dao.jdbcdao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.connection.ConnectionProvider;
import com.connection.JDBCBaseDAO;
import com.dao.CityDAO;
import com.model.City;

public class JDBCCityDAO extends JDBCBaseDAO implements CityDAO {

	public JDBCCityDAO(Connection connection) {
		// this.connection=null;//injection dependency
		this.connection = connection;
	}

	@Override
	public int saveCityDetails(City apmCity) {
		int response = 0;
		try {
			StringBuffer sqlQuery = new StringBuffer();
			sqlQuery.append("INSERT INTO amp_city");
			sqlQuery.append("(state_id, name) ");
			sqlQuery.append("VALUES ");
			sqlQuery.append("(?,?) ");
			PreparedStatement ps = connection.prepareStatement(sqlQuery.toString());
			ps.setInt(1, apmCity.getStateId());
			ps.setString(2, apmCity.getName());
			response = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public int updateCityDetails(City city) {
		int response = 0;
		try {
			StringBuffer sqlQuery = new StringBuffer();
			sqlQuery.append("UPDATE amp_city SET ");
			sqlQuery.append("name=? ,state_id=? WHERE id=?");
			PreparedStatement ps = connection.prepareStatement(sqlQuery.toString());
			ps.setString(1, city.getName());
			ps.setInt(2, city.getStateId());
			ps.setInt(3, city.getId());
			response = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public ArrayList<City> getCityList() {
		ArrayList<City> cityList = new ArrayList<City>();
		try { // we use try catch beacause preparedstatement came into checked statetment

			StringBuffer sqlQuery = new StringBuffer();
			sqlQuery.append("SELECT id, state_id, name FROM apm_city");
			PreparedStatement ps = connection.prepareStatement(sqlQuery.toString());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				City ampCity = new City();// Initialized
				ampCity.setId(rs.getInt("id"));// DATA SETTING
				ampCity.setStateId(rs.getInt("state_id"));
				ampCity.setName(rs.getString("name"));

				cityList.add(ampCity);// INSEERT OBJECT INTO LIST
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return cityList;
	}

	@Override
	public City findCityById(int id) {
		City city = new City();

		try {
			String sqlQuery = "select id,state_id,name from apm_city where id = ?";
			PreparedStatement ps = connection.prepareStatement(sqlQuery);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery(sqlQuery);

			if (rs.next()) {
				city.setId(rs.getInt("id"));
				city.setStateId(rs.getInt("state_id"));
				city.setName(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return city;
	}

	@Override
	public City findCityByName(String name) {
		City city = new City();

		try {
			String sqlQuery = "select id,state_id,name from apm_city where name = ?";
			PreparedStatement ps = connection.prepareStatement(sqlQuery);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery(sqlQuery);

			if (rs.next()) {
				city.setId(rs.getInt("id"));
				city.setStateId(rs.getInt("state_id"));
				city.setName(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return city;
	}

	@Override
	public int getTotalCities() {
		int count = 0;

		try {
			String sqlQuery = "select count(*) as count from apm_city";
			connection = ConnectionProvider.getConnection();
			PreparedStatement ps = connection.prepareStatement(sqlQuery);
			ResultSet rs = ps.executeQuery(sqlQuery);

			if (rs.next()) {
				count = rs.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;
	}

}
