package com.niit.eshop.dao;

import java.util.List;

import com.niit.eshop.model.Category;


public interface CategoryDao {

	public List<Category> list();
	
	public  boolean insertCategory(Category category);

	public java.util.List<Category> getlist();

	public Category getCategoryById(int id);

	public boolean updateCategory(Category category);

	public boolean deleteCategory(int id);
	
	
}
