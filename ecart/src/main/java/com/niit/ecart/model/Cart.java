package com.niit.ecart.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity

public class Cart implements Serializable {
	@Id
	@GeneratedValue
	private int cartId;
	
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public List<CartItem> getCartItems() {
		return cartItems;
	}
	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}
	
	public double getCartTotal() {
		return cartTotal;
	}
	public void setCartTotal(double cartTotal) {
		this.cartTotal = cartTotal;
	}
	public String getCartStatus() {
		return cartStatus;
	}
	public void setCartStatus(String cartStatus) {
		this.cartStatus = cartStatus;
	}
	@OneToMany(mappedBy="cart")
	private List<CartItem> cartItems;
	private double cartTotal;
	private String cartStatus;

}
