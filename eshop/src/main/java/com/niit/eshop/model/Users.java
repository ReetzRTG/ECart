package com.niit.eshop.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

@Entity

public class Users implements Serializable
{
	@Id
	@GeneratedValue
	@Column(name="userid")
	private int userId;
	@NotEmpty(message = "Please enter User Name")
	private String userName;
	@NotEmpty(message = "Please enter Password")
	
	private String userAddress;
	
	
	



	public int getUserId() {
		return userId;
	}






	public void setUserId(int userId) {
		this.userId = userId;
	}






	public String getUserName() {
		return userName;
	}






	public void setUserName(String userName) {
		this.userName = userName;
	}






	public String getUserAddress() {
		return userAddress;
	}






	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}






	public Users()
	{
	}
	// parameterised constructor
	// getter setter
	// validation






	public void setEnabled(boolean b) {
		// TODO Auto-generated method stub
		
	}






	public void setRole(String string) {
		// TODO Auto-generated method stub
		
	}






	public void setCart(Cart cart) {
		// TODO Auto-generated method stub
		
	}
}

 
