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
		a.setUsername("admin1");
		a.setPassword("admin1");
		Admin a1= dao.addOrUpdateAdmin(a);
		assertNotNull(a1);
	}
	
		@Test
		public void adminLogin() {
			Boolean loginResult = dao.adminLogin("admin", "adm");
			if (loginResult != true) {
				System.out.println("Invalid Credentials");
			}else {
				System.out.println("Login Sucessful");
			}
				
		}
		
		@Test
		public void searchAdminTest() {
			Admin a = dao.searchAdminById("admin");
			if(a!=null)
				System.out.println(a.getUsername()+" | "+a.getPassword());
			else
				System.out.println("Not found");
		}
		
		@Test
		public void viewAdmin() {
			
			List<Admin> admins = dao.viewAllAdmins();
			assertNotNull(admins);
			for(Admin a:admins) {
				System.out.println(a.getUsername()+" | "+a.getPassword());
			}
			
		}
	
}
