package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_wishlistitems")
public class WishlistItems {
	
	@Id
	@SequenceGenerator(name = "wishlistitems_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "wishlistitems_seq", strategy = GenerationType.SEQUENCE)
	int wishlistId;
	String productId;
	String quantity;


	@ManyToOne
	@JoinColumn(name = "wishlistId")
	Wishlist wishlist;
	
	@OneToOne
	@JoinColumn(name="productId")
	Product product;

	public int getWishlistId() {
		return wishlistId;
	}

	public void setWishlistId(int wishlistId) {
		this.wishlistId = wishlistId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public Wishlist getWishlist() {
		return wishlist;
	}

	public void setWishlist(Wishlist wishlist) {
		this.wishlist = wishlist;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	

}
