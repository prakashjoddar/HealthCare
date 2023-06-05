package com.constant;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.connection.ConnectionProvider;
import com.dao.CityDAO;
import com.dao.jdbcdao.JDBCCityDAO;
import com.model.City;

class Student {
    String name;
    Student() {
        this.name = "Pro GJ";
        System.out.println("This is Student class");
    }
}

public class TestUtils extends Student {
	
	
	
	
	public TestUtils() {
		super();
		System.out.println(name);
		int arr[] = {3,4,5};
		
		
	}
	
	public static void main(String[] args) {
		
		new TestUtils();
		
		new Thread(()->{System.out.println("Prinitng sysyout");}).start();

		
		
//		Connection connection = null;
//
//		try {
//			connection = ConnectionProvider.getConnection();
//			CityDAO cityDAO = new JDBCCityDAO(connection);
//			ArrayList<City> cityList = cityDAO.getCityList();
//			for (City city : cityList)
//				System.out.println(city.toString());
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				connection.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}

//		LocalDateTime dateTime = LocalDateTime.now();
//		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//		String currentDateTime = dateTime.format(format); 
//		System.out.println(currentDateTime.toString());

	}
}
