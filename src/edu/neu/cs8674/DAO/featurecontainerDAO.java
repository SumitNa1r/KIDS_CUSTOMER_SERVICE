package edu.neu.cs8674.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import edu.neu.cs8674.Objects.featurecontainer;

public class featurecontainerDAO {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("KIDS_CUSTOMER_SERVICE");
	EntityManager em = factory.createEntityManager();
	
	public void create_entity(featurecontainer e)
	{
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
	}
	
	public void delete_entity(int id)
	{
		featurecontainer e = em.find(featurecontainer.class, id);
		em.remove(e);
		em.getTransaction().commit();
	}
	
	public List<featurecontainer> readAll(){
		Query q = em.createQuery("select e from entity e");
		@SuppressWarnings("unchecked")
		List<featurecontainer> e = q.getResultList();
		return e;
	}
}
