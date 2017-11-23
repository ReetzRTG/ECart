package com.niit.ecart.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ecart.model.Category;
import com.niit.ecart.model.Product;

@Repository("productDao")
@Transactional
public class ProductDaoImpl implements ProductDao{
	
	
	
	
		@Autowired
		private SessionFactory sessionFactory;
		
		public void setSessionFactory(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
		}
		protected Session getSession() {
			return sessionFactory.openSession();
		}
		


	public List<Product> list() {
		// TODO Auto-generated method stub
		Session session = getSession();

		Query query = session.createQuery("from Product");
		List<Product> productList = query.list();
        session.close();
		return productList;
	}
	public List<Product> listByCategoryId(int categoryId) {
		// TODO Auto-generated method stub
		Session session = getSession();

		Query query = session.createQuery("from Product where productCategory.categoryId = :categoryId");
		query.setParameter("categoryId", categoryId);
		List<Product> productList = query.list();
        session.close();
        System.out.println("list "+productList);
		return productList;
	}
	
	public Product listByProductId(int productId) {
		// TODO Auto-generated method stub
		Session session = getSession();

		Query query = session.createQuery("from Product where productId = :productId");
		query.setParameter("productId", productId);
		Product product = (Product)query.uniqueResult();
        session.close();
        
		return product;
	}
	
	

}
