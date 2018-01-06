package com.niit.ecart.model;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

@Entity

public class User implements Serializable
{
	@Id
	
	private String id;
	@NotEmpty(message = "Please enter User Name")
	private String name;
	@NotEmpty(message = "Please enter Password")
	@Length(min=5 , max=10)
	private String password;
	private String role;
	private String email;
	public String getEmail() {
		return email;
	}






	public void setEmail(String email) {
		this.email = email;
	}






	public List<OrderDetails> getOrderDetails() {
		return orderDetails;
	}






	public void setOrderDetails(List<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}






	public Cart getCart() {
		return cart;
	}






	public void setCart(Cart cart) {
		this.cart = cart;
	}






	@OneToMany(mappedBy="user")
	private List<OrderDetails> orderDetails;
	@OneToOne
	@JoinColumn(name="cartId")
	Cart cart;
	private boolean enabled;

	
	
	


	public String getId() {
		return id;
	}






	public void setId(String id) {
		this.id = id;
	}






	public String getName() {
		return name;
	}






	public void setName(String name) {
		this.name = name;
	}






	public String getPassword() {
		return password;
	}






	public void setPassword(String password) {
		this.password = password;
	}






	public String getRole() {
		return role;
	}






	public void setRole(String role) {
		this.role = role;
	}






	public boolean isEnabled() {
		return enabled;
	}






	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}






	public User()
	{
	}
	// parameterised constructor
	// getter setter
	// validation
}

 
