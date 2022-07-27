package com.lti.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.RetailerDao;
import com.lti.dto.RetailerSignupDto;
import com.lti.entity.Retailer;
import com.lti.entity.RetailerDocs;

@Service
public class RetailerServiceImpl implements RetailerService {

	@Autowired
	RetailerDao dao;
	public boolean retailerLogin(int retailerId, String password) {
		return false;
	}

	public String signup(RetailerSignupDto rdto) {
		if(dao.retailerExist(rdto.getEmail())){
			return "Email Id Already exist";
		}
		else {
		Retailer r = new Retailer();
		r.setRetailerName(rdto.getRetailerName());
		r.setEmail(rdto.getEmail());
		r.setApproved(false);
		r.setGstnNo(rdto.getGstnNo());
		r.setPassword(rdto.getPassword());
		r.setPhoneNo(rdto.getPhoneNo());
		
		RetailerDocs docs = new RetailerDocs();
		docs.setAddharCard(rdto.getAddharCard());
		docs.setPanCard(rdto.getPanCard());
		docs.setRetailer(r);
		
		r.setRetailerdocs(docs);
		Retailer r1 = dao.addOrUpdate(r);
		
		if(r1!=null) {
			return "Signup successful Your userid is: " + r1.getRetailerId();
		}
		else {
			return "Something went wrong";
		}
	}
	}
	
	
}