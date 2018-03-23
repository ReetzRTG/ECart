package com.niit.eshop.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.eshop.dao.CartItemDao;
import com.niit.eshop.dao.OrderDetailsDao;
import com.niit.eshop.dao.UserDao;
import com.niit.eshop.model.Cart;
import com.niit.eshop.model.CartItem;
import com.niit.eshop.model.OrderDetails;
import com.niit.eshop.model.User;

@Controller
public class OrderController {
	
	@Autowired
	UserDao userDao;
	@Autowired
	CartItemDao  cartItemDao;
	@Autowired
	OrderDetailsDao  orderDetailsDao;
	
	@RequestMapping("/payment") 
	public ModelAndView payment(Principal principal, HttpSession httpSession){
		
		ModelAndView mv=new ModelAndView("payment");
	
				return mv;
	}
	
	@RequestMapping("/checkout")
	public ModelAndView gotocheckout(Principal principal, HttpSession httpSession) {
		ModelAndView mv=new ModelAndView("checkout");
		return mv;
	}
	
	@RequestMapping("/ack")
	public ModelAndView ack(Principal principal, HttpSession httpSession) {
		
		String un=principal.getName();
		User user=userDao.getUsersById(un);
		OrderDetails  orderDetails=(OrderDetails)httpSession.getAttribute("orderDetails");
		Cart cart=user.getCart();
		List<CartItem> cartItems=cartItemDao.getCartItemsByCart(cart);
		for(CartItem cartItem:cartItems){
			cartItem.setOrderDetails(orderDetails);
			cartItem.setCartItemsStatus("ORDERED");
			cartItemDao.updateCartItem(cartItem);
		}
		
		orderDetails.setOrderDetailsStatus("Confirmed");
		orderDetailsDao.updateOrderDetails(orderDetails);
		
		ModelAndView mv=new ModelAndView("ack");
		return mv;
	}
	
	@RequestMapping("/cashpay")
	public ModelAndView cashOnDelivary(Principal principal, HttpSession httpSession) {
		ModelAndView mv=new ModelAndView("cashpay");
		return mv;
	}
	
	@RequestMapping("/orderDetails")
	public ModelAndView orderDetails(Principal principal, HttpSession httpSession) {
		ModelAndView mv=new ModelAndView("orderDetails");
		return mv;
	}
}
