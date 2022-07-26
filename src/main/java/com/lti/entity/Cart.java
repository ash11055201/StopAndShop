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
@Table(name = "tbl_cart")
public class Cart {

	@Id
	@SequenceGenerator(name = "cart_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "cart_seq", strategy = GenerationType.SEQUENCE)
	int cartId;
	
	@OneToOne
	@JoinColumn(name = "customerId")
	Customer customer;
	
	@OneToMany(mappedBy = "cart",cascade = CascadeType.ALL)
	List<CartItems> cartItems;

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<CartItems> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItems> cartItems) {
		this.cartItems = cartItems;
	}
	
	
}
