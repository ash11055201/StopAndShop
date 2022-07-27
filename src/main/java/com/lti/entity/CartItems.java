package com.lti.entity;

import javax.persistence.Column;
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
@Table(name = "tbl_cartitems")
public class CartItems {
	
	@Id
	@SequenceGenerator(name = "cartItems_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "cartItems_seq", strategy = GenerationType.SEQUENCE)
	int cartItemId;
	int productId;
	String quantity;
	


	@ManyToOne
	@JoinColumn(name = "cart_id")
	Cart cart;
	
//	@OneToOne
//	@JoinColumn(name="productId")
//	Product product;


	public int getcartItemId() {
		return cartItemId;
	}


	public void setItemId(int itemId) {
		this.cartItemId = itemId;
	}


	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	

//
//	public Product getProduct() {
//		return product;
//	}
//
//
//	public void setProduct(Product product) {
//		this.product = product;
//	}


	public String getQuantity() {
		return quantity;
	}


	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}


	public Cart getCart() {
		return cart;
	}


	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	
}
