package edu.neu.cs8674.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import edu.neu.cs8674.Objects.fsdtype;

public class fsdtypeDAO {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("KIDS_CUSTOMER_SERVICE");
	EntityManager em = factory.createEntityManager();
	
	public void create_entity(fsdtype e)
	{
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
	}
	
	public void update_entity(fsdtype e, int id){
		em.getTransaction().begin();
		e.setId(id);
		em.merge(e);
		em.getTransaction().commit();		
	}
	
	public void delete_entity(int id)
	{
		fsdtype e = em.find(fsdtype.class, id);
		em.remove(e);
		em.getTransaction().commit();
	}
	
	public fsdtype read_entity_by_id(int id)
	{
		return em.find(fsdtype.class, id);
	}

	public List<fsdtype> readAll(){
		Query q = em.createQuery("select e from entity e");
		@SuppressWarnings("unchecked")
		List<fsdtype> e = q.getResultList();
		return e;
	}

}
