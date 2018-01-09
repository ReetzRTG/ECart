package com.niit.eshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class CartItem {
@Id
@GeneratedValue
private int cartItemId;
public int getCartItemId() {
	return cartItemId;
}


public void setCartItemId(int cartItemId) {
	this.cartItemId = cartItemId;
}





public Product getProduct() {
	return product;
}


public void setProduct(Product product) {
	this.product = product;
}


public Cart getCart() {
	return cart;
}


public void setCart(Cart cart) {
	this.cart = cart;
}


public OrderDetails getOrderDetails() {
	return orderDetails;
}


public void setOrderDetails(OrderDetails orderDetails) {
	this.orderDetails = orderDetails;
}


private String cartItemsStatus;
@OneToOne
@JoinColumn(name="productId")
private Product product;
@ManyToOne
@JoinColumn(name="cartId")
private Cart cart;


public String getCartItemsStatus() {
	return cartItemsStatus;
}


public void setCartItemsStatus(String cartItemsStatus) {
	this.cartItemsStatus = cartItemsStatus;
}


@ManyToOne
@JoinColumn(name="orderDetailsId")
private OrderDetails orderDetails;
private int cartItemQuantity;
private double cartItemSubTotal;
public int getCartItemQuantity() {
	return cartItemQuantity;
}


public void setCartItemQuantity(int cartItemQuantity) {
	this.cartItemQuantity = cartItemQuantity;
}


public double getCartItemSubTotal() {
	return cartItemSubTotal;
}


public void setCartItemSubTotal(double cartItemSubTotal) {
	this.cartItemSubTotal = cartItemSubTotal;
}
}
