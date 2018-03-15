package com.niit.eshop.dao;

import java.util.List;

import com.niit.eshop.model.Users;



public interface UsersDao {
	
	public boolean addUsers(Users users);
	public void updateUsers(Users users);
	public void deleteUsers(int userId);
	public Users getUsersById(int userId);

	public List<Users> getAllUsers();

	public Users getUsersByUsername(String userName);
	

}