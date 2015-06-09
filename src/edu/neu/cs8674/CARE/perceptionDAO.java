package edu.neu.cs8674.CARE;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class perceptionDAO {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("KIDS_CUSTOMER_SERVICE");
	EntityManager em = factory.createEntityManager();
	
	public void create_perception(perception d)
	{
		em.getTransaction().begin();
		em.persist(d);
		em.getTransaction().commit();
	}
	
	public void delete_perception(int id)
	{
		perception d = em.find(perception.class, id);
		em.remove(d);
		em.getTransaction().commit();
	}
}
