package com.mytrip.airlineapp.dao;

import java.util.List;

import com.mytrip.airlineapp.models.Airline;

public interface AirlineDao {
	long saveAirline(Airline airline);
	
	Airline selectAirlineById(long id);
	
	List<Airline> getAllAirlines();
	
	public boolean updateAirline(Airline airline);

	Airline getAirlineByName(String airlineName);
}
