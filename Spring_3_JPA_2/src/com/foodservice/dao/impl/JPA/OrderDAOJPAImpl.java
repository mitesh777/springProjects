package com.foodservice.dao.impl.JPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.foodservice.dao.OrderDao;
import com.foodservice.models.Order;

@Repository
public class OrderDAOJPAImpl implements OrderDao {

	@Override
	public long persistOrder(Order order) {
		// TODO Auto-generated method stub
		String unit = "tps";
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(unit);
		EntityManager em = factory.createEntityManager();
		//Airline airline = new Airline("Airways","type1");
		em.getTransaction().begin();
		em.persist(order);
		em.getTransaction().commit();
		em.close();
		System.out.println(order);
		long id = findByFoodItem(order.getFoodItem()).getOrderId();
		return id;
	}
	
	@Override
	public Order findByFoodItem(String foodItem) {
		// TODO Auto-generated method stub
		String unit = "tps";
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(unit);
		EntityManager em = factory.createEntityManager();
	//	String airName = "Airways";
		String jpq1 = "select oe from OrderEntity oe where oe.foodItem=:name";
		TypedQuery<Order> query = em.createQuery(jpq1, Order.class);
		query.setParameter("name", foodItem);
		Order order=null;
		
		if(query.getResultList().size()!=0)
			order = query.getSingleResult();
	//	System.out.println("jpa returned by name "+airline);
		System.out.println("dao jpa search by name" + order);
		return order;
	}

	@Override
	public Order findByOrderId(long orderId) {
		// TODO Auto-generated method stub
		String unit = "tps";
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(unit);
		EntityManager em = factory.createEntityManager();
		Order order = em.find(Order.class, orderId);
		System.out.println(order);
		return order;
	}

	@Override
	public List<Order> listOrders() {
		String unit = "tps";
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(unit);
		EntityManager em = factory.createEntityManager();
		String jpq1 = "from OrderEntity";
		Query query = em.createQuery(jpq1);
		List<Order> list = query.getResultList();
		return list;
	}

}
