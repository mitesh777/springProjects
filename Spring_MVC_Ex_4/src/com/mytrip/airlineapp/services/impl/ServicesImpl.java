package com.mytrip.airlineapp.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mytrip.airlineapp.dao.AirlineDao;
import com.mytrip.airlineapp.exceptions.AirlineNotFoundException;
import com.mytrip.airlineapp.exceptions.DuplicateAirlineException;
import com.mytrip.airlineapp.models.Airline;
import com.mytrip.airlineapp.services.AirlineService;

@Service
public class ServicesImpl implements AirlineService{
	@Qualifier(value ="jpaDao")
	@Autowired
	private AirlineDao airlineDao;
	
	@Override
	public long addAirline(Airline airline) throws DuplicateAirlineException {
		// TODO Auto-generated method stub
		long id = 0;
		Airline airlineByName = airlineDao.getAirlineByName(airline.getAirlineName());
		if(airlineByName != null) {
			String errorMsg = airline.getAirlineName() + " airline exists";
			throw new DuplicateAirlineException(errorMsg);
		}
		else {
			return airlineDao.saveAirline(airline);
		}
		
		//return airlineDao.saveAirline(airline);
	}

	@Override
	public boolean updateAirline(Airline airline) {
		// TODO Auto-generated method stub
		return airlineDao.updateAirline(airline);
	}

	@Override
	public Airline getAirlineById(long airlineId) throws AirlineNotFoundException {
		// TODO Auto-generated method stub
		Airline airline = airlineDao.selectAirlineById(airlineId);
		if(airline == null) {
			throw new AirlineNotFoundException(airlineId + "not found");
		}
		return airline;
	}
	
	@Override
	public Airline getAirlineByName(String name) throws AirlineNotFoundException {
		// TODO Auto-generated method stub
		Airline airline = airlineDao.getAirlineByName(name);
		if(airline == null) {
			throw new AirlineNotFoundException(name + " not found");
		}
		return airline;
	}

	@Override
	public List<Airline> getAllAirlines() {
		// TODO Auto-generated method stub
		return airlineDao.getAllAirlines();
	}
	
}
