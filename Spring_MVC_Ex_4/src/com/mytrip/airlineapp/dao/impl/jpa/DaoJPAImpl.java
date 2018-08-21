package com.mytrip.airlineapp.dao.impl.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.mytrip.airlineapp.dao.AirlineDao;
import com.mytrip.airlineapp.models.Airline;

@Repository(value ="jpaDao")
public class DaoJPAImpl implements AirlineDao{

	@Override
	public long saveAirline(Airline airline) {
		// TODO Auto-generated method stub
		String unit = "tps";
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(unit);
		EntityManager em = factory.createEntityManager();
		//Airline airline = new Airline("Airways","type1");
		em.getTransaction().begin();
		em.persist(airline);
		em.getTransaction().commit();
		em.close();
		System.out.println(airline);
		long id = getAirlineByName(airline.getAirlineName()).getId();
		return id;
	}

	@Override
	public Airline selectAirlineById(long id) {
		// TODO Auto-generated method stub
		String unit = "tps";
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(unit);
		EntityManager em = factory.createEntityManager();
		Airline airline = em.find(Airline.class, id);
		System.out.println(airline);
		return airline;
	}

	@Override
	public List<Airline> getAllAirlines() {
		// TODO Auto-generated method stub
		String unit = "tps";
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(unit);
		EntityManager em = factory.createEntityManager();
		String jpq1 = "from AirlineEntity";
		Query query = em.createQuery(jpq1);
		List<Airline> list = query.getResultList();
		return list;
	}

	@Override
	public boolean updateAirline(Airline airline) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Airline getAirlineByName(String airlineName) {
		String unit = "tps";
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(unit);
		EntityManager em = factory.createEntityManager();
	//	String airName = "Airways";
		String jpq1 = "select ae from AirlineEntity ae where ae.airlineName=:name";
		TypedQuery<Airline> query = em.createQuery(jpq1,Airline.class);
		query.setParameter("name", airlineName);
		Airline airline=null;
		
		if(query.getResultList().size()!=0)
			airline = query.getSingleResult();
	//	System.out.println("jpa returned by name "+airline);
		System.out.println("dao jpa search by name" + airline);
		return airline;
	}

}
