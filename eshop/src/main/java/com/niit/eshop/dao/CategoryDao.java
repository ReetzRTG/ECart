package com.niit.eshop.dao;

import java.util.List;

import com.niit.eshop.model.Category;


public interface CategoryDao {

	public List<Category> list();

	public void insertCategory(Category category);

	public java.util.List<Category> getlist();

	public Category getCategoryById(int id);

	public void updateCategory(Category category);

	public void deleteCategory(int id);
	
	
}
