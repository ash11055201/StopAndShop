package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.Admin;

@Repository
public class AdminDaoImpl implements AdminDao {

	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public Admin addOrUpdateAdmin(Admin admin) {

		Admin userPersisted = em.merge(admin);
		return userPersisted;
	}
public boolean adminLogin(String username, String password) {
		
	String jpql = "select u from Admin u where u.username=:uid and u.password=:pwd";
	TypedQuery<Admin> query=em.createQuery(jpql, Admin.class);
	query.setParameter("uid",username);
	query.setParameter("pwd", password);
	
	
	Admin admin=null;
    try {
    admin= query.getSingleResult();
    }catch(Exception e) {
        return false;
    }
    return true;
	}

public Admin searchAdminById(String userId) {
	// TODO Auto-generated method stub
	return em.find(Admin.class, userId);
}

public List<Admin> viewAllAdmins() {
	String jpql ="select u from Admin u";
	TypedQuery<Admin> query = em.createQuery(jpql,Admin.class);
	return query.getResultList();
}

}
