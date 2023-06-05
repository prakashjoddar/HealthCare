package com.model;

public class City {
	private int id;
	private int stateId;
	private String name;
	
//	public ApmCity(int id, int stateId, String name) {
//		super();
//		this.id = id;
//		this.stateId = stateId;
//		this.name = name;
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ApmCity [id=" + id + ", stateId=" + stateId + ", name=" + name + "]";
	}
	
	
}
