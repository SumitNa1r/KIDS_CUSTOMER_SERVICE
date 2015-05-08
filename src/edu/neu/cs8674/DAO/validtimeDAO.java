package edu.neu.cs8674.DAO;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import edu.neu.cs8674.Objects.validtime;

public class validtimeDAO {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("KIDS_CUSTOMER_SERVICE");
	EntityManager em = factory.createEntityManager();
	
	public void create_entity(validtime e)
	{
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
	}

	public validtime read_validtime(Date st, Date et)
	{
		Query query = em.createQuery("select v from validtime v where v.startTime = :starttime and v.endTime = :endtime ");
		query.setParameter("starttime", st);
		query.setParameter("endtime", et);
		validtime v = (validtime)query.getSingleResult();
		return v;		
	}
	
	public void delete_validtime(Date st, Date et)
	{
		Query query = em.createQuery("select v from validtime v where v.startTime = :starttime and v.endTime = :endtime ");
		query.setParameter("starttime", st);
		query.setParameter("endtime", et);
		validtime v = (validtime)query.getSingleResult();
		em.getTransaction().begin();
		em.remove(v);
		em.getTransaction().commit();		
	}
	
	public List<validtime> readAll_validtime(Date st, Date et)
	{
		Query query = em.createQuery("select v from validtime v"); 
		@SuppressWarnings("unchecked")
		List<validtime> v = query.getResultList();
		return v;		
	}
	
	
	
}
