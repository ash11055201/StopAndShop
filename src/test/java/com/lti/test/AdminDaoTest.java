package com.lti.test;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.dao.AdminDao;
import com.lti.entity.Admin;
import com.lti.entity.Category;
import com.lti.entity.ProductType;
import com.lti.entity.Retailer;

public class AdminDaoTest {

	@Autowired
	AdminDao dao;

	@Before
	public void initializeDao() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		dao = context.getBean(AdminDao.class);
	}

	@Test
	public void addOrUpdateAdmin() {
		
		Admin a = new Admin();
		a.setPassword("admin");
		a.setUsername("admin");
		Admin a2=dao.addOrUpdateAdmin(a);
		assertNotNull(a2);
		
		List<Admin> admins= dao.viewadmins();
		for(Admin a1 : admins) {
			System.out.println(a1.getPassword()+" "+a1.getUsername());
		}

	}
	
	@Test
	public void adminLogin() {
		Boolean loginResult = dao.adminLogin("admin","admi");
		if (loginResult != true) {
			System.out.println("Invalid Credentials");
		} else {
			System.out.println("Login Sucessful");
		}

	}
	
	@Test
	public void viewRetailerDetails() {
		Retailer r=dao.viewRetailerDetails(1006);
		assertNotNull(r);
		System.out.println(r.getRetailerdocs().toString());
	}

	@Test
	public void viewRetailers() {
		List<Retailer> retailers = dao.approvedRetailers();
//		List<Retailer> retailers = dao.nonApprovedRetailers();
		if(retailers.isEmpty())
			System.out.println("No Record Found");
		else
			for(Retailer r:retailers)
				System.out.println(r.toString());
	}
	
	@Test
	public void approveRetailer() {
		Retailer r=dao.searchRetailer(1010);
		if(r!=null) {
			r.setApproved(true);
			System.out.println(dao.approveReailer(r));
		}
		else
			System.out.println("Retailer not present");
	}
	
	@Test
	public void removeTest() {
		dao.removeRetailer(1006);
	}
	
	@Test
	public void addCategoryTest() {
		Category c= new Category();
		c.setCategoryName("Mobile");
		c.setCategoryImage("cimage");
		
		Category c1 = dao.addOrUpdateCategory(c);
		assertNotNull(c1);
	}
	
	@Test
	public void updateCategoryTest() {
		Category c= new Category();
		c.setCategoryId(102);
		c.setCategoryName("Electronics");
		c.setCategoryImage("cimage");
		
		Category c1 = dao.addOrUpdateCategory(c);
		assertNotNull(c1);
	}
	
	@Test
	public void removeCategory() {
		dao.removeCategory(104);
	}
	
	@Test
	public void findCategory() {
		Category c = dao.findCategory(103);
		assertNotNull(c);	
	}
	
	
	@Test
	public void addptypeTest() {
		ProductType p= new ProductType();
		p.setProductTypeName("Mobile");
		p.setProductImage("ptimage");
		
		Category c= dao.findCategory(102);
		assertNotNull(c);
		p.setCategory(c);
		
		ProductType pt=dao.addOrUpdateProductType(p);
		assertNotNull(pt);
	}
	
	@Test
	public void updateptypeTest() {
		ProductType p= new ProductType();
		p.setProductTypeId(101);
		p.setProductTypeName("Mobil");
		p.setProductImage("ptimage");
		
		Category c= dao.findCategory(102);
		p.setCategory(c);
		
		ProductType c1 = dao.addOrUpdateProductType(p);
		assertNotNull(c1);
	}
	
	@Test
	public void removeptype() {
		dao.removeCategory(101);
	}
	
	@Test
	public void findptype() {
		Category c = dao.findCategory(102);
		assertNotNull(c);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
