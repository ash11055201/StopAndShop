package com.lti.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_customer")
public class Customer {
	@Id
	@SequenceGenerator(name = "product_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "product_seq", strategy = GenerationType.SEQUENCE)
 	int customerId;
	String customerName;
	String emailId;
	String password;
	String phoneNo;
	
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
	List<CustomerAddress> address;
}
