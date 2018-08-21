//package com.mytrip.airlineapp.models;
//
//public class Airline {
//	@Override
//	public String toString() {
//		return "Airline [id=" + id + ", airlineName=" + airlineName + ", serviceType=" + serviceType + "]";
//	}
//	private long id;
//	private String airlineName;
//	private String serviceType;
//	
//	
//	
//	public long getId() {
//		return id;
//	}
//
//	public void setId(long id) {
//		this.id = id;
//	}
//
//	public Airline(long id, String airlineName, String serviceType) {
//		super();
//		this.id = id;
//		this.airlineName = airlineName;
//		this.serviceType = serviceType;
//	}
//
//	public Airline() {
//		super();
//	}
//
//	public Airline(String airlineName, String serviceType) {
//		super();
//		this.airlineName = airlineName;
//		this.serviceType = serviceType;
//	}
//	
//	public String getAirlineName() {
//		return airlineName;
//	}
//	public void setAirlineName(String airlineName) {
//		this.airlineName = airlineName;
//	}
//	public String getServiceType() {
//		return serviceType;
//	}
//	public void setServiceType(String serviceType) {
//		this.serviceType = serviceType;
//	}
//	
//	
//}
package com.mytrip.airlineapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "AirlineEntity")
@Table(name = "Airlines")
public class Airline {
	@Override
	public String toString() {
		return "Airline [id=" + id + ", airlineName=" + airlineName + ", serviceType=" + serviceType + "]";
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String airlineName;
	private String serviceType;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Airline(long id, String airlineName, String serviceType) {
		super();
		this.id = id;
		this.airlineName = airlineName;
		this.serviceType = serviceType;
	}

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

