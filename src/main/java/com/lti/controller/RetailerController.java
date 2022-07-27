package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.RetailerSignupDto;
import com.lti.service.RetailerService;

@RestController
@RequestMapping("/retailer")
public class RetailerController {
	
	@Autowired
	RetailerService retailerService;	
	
//	http://localhost:8181/UserManagementRestWebApp/myapp/users/signup - url
	@RequestMapping(value="/signup" , method=RequestMethod.POST) //new usersignup
	public String signup(@RequestBody RetailerSignupDto rdto) {
		String message=retailerService.signup(rdto);
		return message;
	}
}
