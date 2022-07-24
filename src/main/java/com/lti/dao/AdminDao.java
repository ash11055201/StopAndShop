package com.lti.dao;

import java.util.List;

import com.lti.entity.Admin;

public interface AdminDao {

	Admin addOrUpdateAdmin(Admin admin);

	boolean adminLogin(String username, String password);

	Admin searchAdminById(String userId);

	List<Admin> viewAllAdmins();
}
