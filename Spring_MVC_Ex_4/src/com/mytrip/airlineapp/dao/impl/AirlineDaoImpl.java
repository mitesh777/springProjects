package com.mytrip.airlineapp.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mytrip.airlineapp.dao.AirlineDao;
import com.mytrip.airlineapp.models.Airline;
@Repository
public class AirlineDaoImpl implements AirlineDao {
	
	private List<Airline> airlines;
	
	public AirlineDaoImpl() {
		this.airlines = new ArrayList<Airline>();
		this.airlines.add(new Airline(1L,"Airline_1","type_1"));
		this.airlines.add(new Airline(2L,"Airline_2","type_2"));
	}
	
	@Override
	public long saveAirline(Airline airline) {
		// TODO Auto-generated method stub
		int size = airlines.size()+1;
		airline.setId(size);
		this.airlines.add(airline);
		System.out.println("added= "+airline);
		return airline.getId();
	}

	@Override
	public Airline selectAirlineById(long id) {
		// TODO Auto-generated method stub
		for(Airline airline: airlines) {
			if(airline.getId()==id) {
				return airline;
			}
		}
		//if(airlines.)
		return null;
		//return null;
	}

	@Override
	public List<Airline> getAllAirlines() {
		// TODO Auto-generated method stub
		return airlines;
	}

	@Override
	public boolean updateAirline(Airline airline) {
		// TODO Auto-generated method stub
		int i=0;
		boolean status=false;
		for(Airline airlineCurr: airlines) {
			if(airline.getId()==airlineCurr.getId()) {
				status=true;
				airlines.set(i,airline);
				break;
			}
			i++;
		}
		
		return status;
	}

	@Override
	public Airline getAirlineByName(String airlineName) {
		// TODO Auto-generated method stub
		for(Airline airlineCurr: airlines) {
			if(airlineName.equals(airlineCurr.getAirlineName())) {
				return airlineCurr;
			}
			
		}
		return null;
	}

}
