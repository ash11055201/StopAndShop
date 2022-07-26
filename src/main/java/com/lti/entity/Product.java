package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_product")
public class Product {

	@Id
	@SequenceGenerator(name = "product_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "product_seq", strategy = GenerationType.SEQUENCE)
	int productId;
	String productName;
	String productImage;
	double price;
	String productDescription;
	String brand;
	String warranty;
	double availableStocks;
	boolean approvedStatus;

	@ManyToOne
	@JoinColumn(name = "productTypeId")
	ProductType productType;
	
	@ManyToOne
	@JoinColumn(name = "retailer")
	Retailer retailer;
}
