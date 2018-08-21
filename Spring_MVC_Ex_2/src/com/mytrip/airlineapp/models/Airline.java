package com.mytrip.airlineapp.models;

public class Airline {
	//private int id;
	private String airlineName;
	private String serviceType;
	
	
	
	public Airline() {
		super();
	}

	public Airline(String airlineName, String serviceType) {
		super();
		this.airlineName = airlineName;
		this.serviceType = serviceType;
	}
	
	public String getAirlineName() {
		return airlineName;
	}
	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	
	
}
