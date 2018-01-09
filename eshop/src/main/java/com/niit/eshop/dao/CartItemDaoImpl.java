package com.niit.eshop.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.eshop.dao.CartItemDao;
import com.niit.eshop.model.Cart;
import com.niit.eshop.model.CartItem;
import com.niit.eshop.model.OrderDetails;

@Repository("CartItemDao")
@Transactional

public class CartItemDaoImpl implements CartItemDao{
	@Autowired
	private SessionFactory sessionFactory;

	protected SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	protected void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	protected Session getSession(){
		return sessionFactory.openSession();
	}
	public boolean insertCartItem(CartItem cartItem){
		Session session=getSession();
		try{
			session.save(cartItem);
			return true;
		}catch(HibernateException e){
			e.printStackTrace();
			return false;
		}finally {
			session.flush();
			session.close();
		}
	}

	
	
	
	public boolean deleteCartItem(CartItem cartItem) {
		// TODO Auto-generated method stub
		
		Session session=getSession();
		try{
			session.delete(cartItem);
			return true;
		}
		catch(HibernateException e){
			e.printStackTrace();
     		return false;}finally {
     			session.flush();
     			session.close();
     		}
	}
	


	
	
	
	public boolean updateCartItem(CartItem cartItem) {
		// TODO Auto-generated method stub
		Session session=getSession();
		try{
			session.update(cartItem);
			return true;		}
		catch(HibernateException e){
			e.printStackTrace();
		    return false;
	}finally {
		session.flush();
		session.close();
	}
	}
	

	
	
	
	public List<CartItem> getAllCartItem() {
		// TODO Auto-generated method stub
		Session session=getSession();
		try{
			Query query=session.createQuery("From CartItem where cartItemsStatus != 'ORDERED'");
			return query.list();
		}
		catch(HibernateException e){
			e.printStackTrace();
     		return null;
	}
	}

	
	
	
	public List<CartItem> getCartItemsByCart(Cart cart) {
		// TODO Auto-generated method stub
		Session session=getSession();
		try{
			Query query=session.createQuery("From CartItem where cart.cartId = ? And cartItemsStatus = ?");
			query.setInteger(0, cart.getCartId());
			query.setString(1, "N");
			
			return query.list();
		}
		catch(HibernateException e){
			e.printStackTrace();
     		return null;
	}finally {
		session.flush();
		session.close();
	}
	}

	
	
	
	public CartItem getCartItemByCartItemId(int cartItemnId) {
		// TODO Auto-generated method stub
		Session session=getSession();
		try{
			Query query=session.createQuery("From CartItem where cartItemId=?");
			query.setParameter(0, cartItemnId);
			
			return (CartItem)query.uniqueResult();
		}
		catch(HibernateException e){
			e.printStackTrace();
     		return null;
	}
	}
	

	
	
	public List<CartItem> getCartItemsByOrderDetails(OrderDetails orderDetails) {
		// TODO Auto-generated method stub
		Session session=getSession();
		try{
			Query query=session.createQuery("From CartItem where orderDetails.orderDetailsId = ? And cartItemStatus = ?");
			query.setInteger(0, orderDetails.getOrderDetailsId());
		query.setString(1, "ORDERED");	
			return query.list();
		}
		catch(HibernateException e){
			e.printStackTrace();
     		return null;
	}finally {
		session.flush();
		session.close();
	}
	}
	
	

	
	
	
		
	}

	

