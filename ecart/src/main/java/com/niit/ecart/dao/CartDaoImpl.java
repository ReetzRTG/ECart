package com.niit.ecart.dao;

import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ecart.model.Cart;
import com.niit.ecart.model.User;

@Repository("CartDaoImpl")
@Transactional


public class CartDaoImpl implements CartDao {
	@Autowired
	private SessionFactory sessionFactory; 
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	protected Session getSession(){
		return sessionFactory.openSession();
	}
	
	public boolean insertCart (Cart cart){
		Session session=getSession();
		try{
			
			session.save(cart);
			session.flush();
			session.close();
			return true;
		}catch(HibernateException e) {
			e.printStackTrace();
			return false;
		}
			
	}
	
	public boolean deleteCart(Cart cart){
		Session session=getSession();
		try{
		session.delete(cart);
		return true;
		}catch(HibernateException e){
			e.printStackTrace();
			return false;
		}
		finally{
			session.flush();
			session.close();
		}
	}
	
	public boolean updateCart(Cart cart){
		Session session=getSession();
		try{
			
			session.update(cart);
			return true;
		}catch(HibernateException e){
			e.printStackTrace();
			return false;
		}
		finally{
			session.flush();
			session.close();
		}	
		}
	public List<Cart> getAllCart(){
		try{
			Session session=getSession();
			Query query=session.createQuery("form Cart");
			 
			return query.list();
		}catch(HibernateException e){
			System.out.println(e.toString());
			return null;
		}
	}
	
	public Cart getCartByUser(User user){
		Session session=getSession();
		try{
			Query query=session.createQuery("from Cart where user.userId =:userId");
			query.setParameter("userId",user.getId());
			return (Cart)query.uniqueResult();
			
		}catch(HibernateException e){
			e.printStackTrace();
			return null;
		}finally{
			session.flush();
			session.close();
		}
	}
	
	public Cart getCartByCartId(int cartId){
		Session session=getSession();
		try{
			Query query=session.createQuery("from cart where cartId= ?");
			query.setInteger(0, cartId);
			session.flush();
			session.close();
			return (Cart)query.uniqueResult();
		}catch(HibernateException e){
		System.out.println(e.toString());
		return null;
	}

		}
	
}
	

	


