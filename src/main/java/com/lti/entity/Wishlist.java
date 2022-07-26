package com.lti.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_wishlist")
public class Wishlist {
	
	@Id
	@SequenceGenerator(name = "wishlist_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "wishlist_seq", strategy = GenerationType.SEQUENCE)
	int wishlistId;
	
	@OneToOne
	@JoinColumn(name = "customerId")
	Customer customer;
	
	@OneToMany(mappedBy = "wishlist",cascade = CascadeType.ALL)
	List<WishlistItems> wishlistItems;

	public int getWishlistId() {
		return wishlistId;
	}

	public void setWishlistId(int wishlistId) {
		this.wishlistId = wishlistId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<WishlistItems> getWishlistItems() {
		return wishlistItems;
	}

	public void setWishlistItems(List<WishlistItems> wishlistItems) {
		this.wishlistItems = wishlistItems;
	}

	
}
