package edu.neu.cs8674.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import edu.neu.cs8674.Objects.fsdcontainer;

public class fsdcontainerDAO {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("KIDS_CUSTOMER_SERVICE");
	EntityManager em = factory.createEntityManager();
	
	public void create_entity(fsdcontainer e)
	{
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
	}
	
	public void delete_entity(int id)
	{
		fsdcontainer e = em.find(fsdcontainer.class, id);
		em.remove(e);
		em.getTransaction().commit();
	}
	
	public List<fsdcontainer> readAll(){
		Query q = em.createQuery("select e from entity e");
		@SuppressWarnings("unchecked")
		List<fsdcontainer> e = q.getResultList();
		return e;
	}

}
