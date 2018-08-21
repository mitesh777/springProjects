package com.mytrip.airlineapp.services;

import java.util.List;

import com.mytrip.airlineapp.exceptions.AirlineNotFoundException;
import com.mytrip.airlineapp.exceptions.DuplicateAirlineException;
import com.mytrip.airlineapp.models.Airline;

public interface AirlineService {
	long addAirline(Airline airline) throws DuplicateAirlineException;
	
	boolean updateAirline(Airline airline);
	
	Airline getAirlineById(long airlineId) throws AirlineNotFoundException;
	
	List<Airline> getAllAirlines();

	Airline getAirlineByName(String name) throws AirlineNotFoundException;
}
