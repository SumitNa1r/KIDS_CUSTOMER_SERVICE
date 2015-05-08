package edu.neu.cs8674.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import edu.neu.cs8674.Objects.guard;

public class guardDAO {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("KIDS_CUSTOMER_SERVICE");
	EntityManager em = factory.createEntityManager();
	
	public void create_entity(guard e)
	{
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
	}
	
	public void update_entity(guard e, int id){
		em.getTransaction().begin();
		e.setId(id);
		em.merge(e);
		em.getTransaction().commit();		
	}
	
	public void delete_entity(int id)
	{
		guard e = em.find(guard.class, id);
		em.remove(e);
		em.getTransaction().commit();
	}
	
	public guard read_entity_by_id(int id)
	{
		return em.find(guard.class, id);
	}

	public List<guard> readAll(){
		Query q = em.createQuery("select e from entity e");
		@SuppressWarnings("unchecked")
		List<guard> e = q.getResultList();
		return e;
	}

}
