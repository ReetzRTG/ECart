package com.niit.eshop.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.eshop.model.Category;


@Repository("categoryDao")
@Transactional
public class CategoryDaoImpl implements CategoryDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	protected Session getSession() {
		return sessionFactory.openSession();
	}
	public List<Category> list() {
		// TODO Auto-generated method stub
		Session session = getSession();

		Query query = session.createQuery("from Category");
		List<Category> categoryList = query.list();
        session.close();
		return categoryList;
	}
	public void insertCategory(Category category) {
		// TODO Auto-generated method stub
		
	}
	public List<Category> getlist() {
		// TODO Auto-generated method stub
		return null;
	}
	public Category getCategoryById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	public void updateCategory(Category category) {
		// TODO Auto-generated method stub
		
	}
	public void deleteCategory(int id) {
		// TODO Auto-generated method stub
		
	}

}
