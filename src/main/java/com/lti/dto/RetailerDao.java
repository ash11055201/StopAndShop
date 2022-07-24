package com.lti.dto;

import com.lti.entity.Retailer;

public interface RetailerDao {
	
	Retailer addOrUpdate(Retailer retailer);
	boolean login(int retailerId , String password);
}
