package com.lti.dto;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.lti.entity.Retailer;

@Repository
public class RetailerDaoImpl implements RetailerDao {

	@PersistenceContext
	EntityManager em;


	public Retailer addOrUpdate(Retailer retailer) {
		
		Retailer retailerPersisted= em.merge(retailer);
		return retailerPersisted;
	}
	
	public boolean login(int retailerId, String password) {
		
		String jpql="select a from Retailer a where retailerId=:rid and password=:pwd";
		TypedQuery<Retailer> query=em.createQuery(jpql,Retailer.class);
		query.setParameter("rid",retailerId);
		query.setParameter("pwd",retailerId);
		return true;
	}
}
