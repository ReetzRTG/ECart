package com.niit.ecart.dao;
import java.util.List;

import com.niit.crud.model.User;



public interface UserDao {
	public void addUsers(User users);

	public User getUsersById(int userId);

	public List<User> getAllUsers(String un);

	public User getUsersByUsername(String userName);
	public void editUsers(User users);
}
