package com.lti.entity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class CustomerAddress {
	
	int addressId;
	String houseNo;
	String building;
	String city;
	String state;
	String pinCode;
	String country;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	Customer customer;


}
