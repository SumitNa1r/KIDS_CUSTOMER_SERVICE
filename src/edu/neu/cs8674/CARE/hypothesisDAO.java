package edu.neu.cs8674.CARE;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class hypothesisDAO {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("KIDS_CUSTOMER_SERVICE");
	EntityManager em = factory.createEntityManager();
	
	public void create_directive(hypothesis d)
	{
		em.getTransaction().begin();
		em.persist(d);
		em.getTransaction().commit();
	}
	
	public void delete_directive(int id)
	{
		hypothesis d = em.find(hypothesis.class, id);
		em.remove(d);
		em.getTransaction().commit();
	}
}
