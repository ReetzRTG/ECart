package com.niit.eshop.dao;
import java.util.List;

import com.niit.eshop.model.User;



public interface UserDao {
	public boolean addUsers(User users);

	public User getUsersById(String userId);

	public List<User> getAllUsers(String un);

	public User getUsersByUsername(String userName);
	public boolean editUsers(User users);
}