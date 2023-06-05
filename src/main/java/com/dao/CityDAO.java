package com.dao;

import java.util.ArrayList;
import com.model.City;
import com.model.UserDetails;

public interface CityDAO {
	public int saveCityDetails(City employee);
	public int updateCityDetails(City employee);
	public ArrayList<City> getCityList();
	public City findCityById(int id);
	public City findCityByName(String name);
	public int getTotalCities();
	
}
