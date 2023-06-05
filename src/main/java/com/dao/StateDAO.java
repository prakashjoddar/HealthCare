package com.dao;

import java.util.ArrayList;

import com.model.City;
import com.model.State;

public interface StateDAO {
	public int saveStateDetails(State state);
	public int updateStateDetails(State state);
	public ArrayList<State> getStateList();
	public State findStateById(int id);
	public State findStateByName(String name);
	public int getTotalStates();

}
