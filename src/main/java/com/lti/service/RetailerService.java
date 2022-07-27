package com.lti.service;

import com.lti.dto.RetailerSignupDto;

public interface RetailerService {
	boolean retailerLogin(int retailerId,String password);
	String signup(RetailerSignupDto rdto);
	
}
