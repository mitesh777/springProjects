package com.mytrip.airlineapp.main;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.mytrip.airlineapp.models.Airline;

public class JPA_Main {
	public static void main(String[] args) {
		//storeData();
		retrieveAll();
	}

	private static void retrieveDataById() {
		// TODO Auto-generated method stub
		String unit = "tps";
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(unit);
		EntityManager em = factory.createEntityManager();
		Airline airline = em.find(Airline.class, 6L);
		System.out.println(airline);
	}
	
	private static void retrieveAll() {
		// TODO Auto-generated method stub
		String unit = "tps";
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(unit);
		EntityManager em = factory.createEntityManager();
		String jpq1 = "from AirlineEntity";
		Query query = em.createQuery(jpq1);
		List<Airline> list = query.getResultList();
		for(Airline airline:list) {
			System.out.println(airline);
		}
	}
	
	private static void retrieveDataByName() {
		// TODO Auto-generated method stub
		String unit = "tps";
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(unit);
		EntityManager em = factory.createEntityManager();
		String airName = "Airways";
		String jpq1 = "select ae from AirlineEntity ae where ae.airlineName=:name";
		TypedQuery<Airline> query = em.createQuery(jpq1,Airline.class);
		query.setParameter("name", airName);
		Airline airline = query.getSingleResult();
		System.out.println(airline);
	}

	private static void storeData() {
		// TODO Auto-generated method stub
		String unit = "tps";
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(unit);
		EntityManager em = factory.createEntityManager();
		Airline airline = new Airline("Airways","type1");
		em.getTransaction().begin();
		em.persist(airline);
		em.getTransaction().commit();
		em.close();
		System.out.println(airline);
	}
	
	
}
