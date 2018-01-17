package com.niit.eshop.dao;

import java.util.List;

import org.hibernate.HibernateException;
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
	private int categoryId;
	
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
	public boolean insertCategory(Category category) {
		// TODO Auto-generated method stub
		try{
			Session session = getSession();
			session.save(category);
			session.flush();
			session.close();
			return true;
		}
		catch(HibernateException e)
		{
			return false;
		}
	}
	public List<Category> getlist() {
		// TODO Auto-generated method stub
		Session session = getSession();
		
		Query query = session.createQuery("from Category");
		List<Category> categoryList = query.list();
		return categoryList;
	}
	public Category getCategoryById(int categoryId) {
		// TODO Auto-generated method stub
		Session session = getSession();
		
		Query query = session.createQuery("from Category where categoryId = ?");
		query.setInteger(0, categoryId);
		return(Category) query.uniqueResult();
	}
	public boolean updateCategory(Category category) {
		// TODO Auto-generated method stub
		try{
			Session session = getSession();
			session.update(category);
			session.flush();
			session.close();
			return true;
		}
		catch(HibernateException e)
		{
			return false;
		}
	}
	public boolean deleteCategory(int id) {
		// TODO Auto-generated method stub
		try{
			Session session = getSession();
			Query query = session.createQuery("from Category where categoryId = ?");
			query.setInteger(0, categoryId);
			
			Category u=(Category) query.uniqueResult();
			session.delete(u);
			session.flush();
			
			session.close();
			return true;
		}
		catch(HibernateException e)
		{
			return false;
		}
		}
	
	}
