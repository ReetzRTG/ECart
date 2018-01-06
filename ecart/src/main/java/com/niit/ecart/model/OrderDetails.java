package com.niit.ecart.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class OrderDetails implements Serializable {

	@Id
	@GeneratedValue
	private int orderDetailsId;
	private String OrderDetailsStatus;
	@OneToMany(mappedBy="orderDetails")
	List<CartItem> cartItems;
	private Date orderDetails;
	@ManyToOne
	@JoinColumn(name="userId")
	User user;
	public int getOrderDetailsId() {
		return orderDetailsId;
	}
	public void setOrderDetailsId(int orderDetailsId) {
		this.orderDetailsId = orderDetailsId;
	}
	public String getOrderDetailsStatus() {
		return OrderDetailsStatus;
	}
	public void setOrderDetailsStatus(String orderDetailsStatus) {
		OrderDetailsStatus = orderDetailsStatus;
	}
	public List<CartItem> getCartItems() {
		return cartItems;
	}
	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}
	public Date getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(Date orderDetails) {
		this.orderDetails = orderDetails;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getOrderDetailsAddress() {
		return orderDetailsAddress;
	}
	public void setOrderDetailsAddress(String orderDetailsAddress) {
		this.orderDetailsAddress = orderDetailsAddress;
	}
	public int getOrderDetailsPin() {
		return orderDetailsPin;
	}
	public void setOrderDetailsPin(int orderDetailsPin) {
		this.orderDetailsPin = orderDetailsPin;
	}
	public double getOrderDetailsTotal() {
		return orderDetailsTotal;
	}
	public void setOrderDetailsTotal(double orderDetailsTotal) {
		this.orderDetailsTotal = orderDetailsTotal;
	}
	private String orderDetailsAddress;
	private int orderDetailsPin;
	private double orderDetailsTotal;
	
}
