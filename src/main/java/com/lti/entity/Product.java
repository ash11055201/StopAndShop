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

//	@OneToOne(mappedBy = "product",cascade = CascadeType.ALL)
//	WishlistItems wishlistItems;
//	
//	@OneToOne(mappedBy = "product",cascade = CascadeType.ALL)
//	CartItems cartItems;
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getWarranty() {
		return warranty;
	}

	public void setWarranty(String warranty) {
		this.warranty = warranty;
	}

	public double getAvailableStocks() {
		return availableStocks;
	}

	public void setAvailableStocks(double availableStocks) {
		this.availableStocks = availableStocks;
	}

	public boolean isApprovedStatus() {
		return approvedStatus;
	}

	public void setApprovedStatus(boolean approvedStatus) {
		this.approvedStatus = approvedStatus;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public Retailer getRetailer() {
		return retailer;
	}

	public void setRetailer(Retailer retailer) {
		this.retailer = retailer;
	}
	
	
	
}
