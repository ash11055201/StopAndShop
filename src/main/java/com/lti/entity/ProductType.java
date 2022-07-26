package com.lti.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_producttype")
public class ProductType {
	
	@Id
	@SequenceGenerator(name = "producttype_seq", initialValue = 501, allocationSize = 1)
	@GeneratedValue(generator = "producttype_seq", strategy = GenerationType.SEQUENCE)
	int productTypeId;

	String productTypeName;

	@ManyToOne
	@JoinColumn(name = "categoryId")
	Category category;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	List<ProductType> productType;
}
