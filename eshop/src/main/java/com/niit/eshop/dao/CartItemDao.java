package com.niit.eshop.dao;

import java.util.List;

import com.niit.eshop.model.Cart;
import com.niit.eshop.model.CartItem;
import com.niit.eshop.model.OrderDetails;

public interface CartItemDao {

	
	public boolean insertCartItem(CartItem cartItem);
	public boolean deleteCartItem(CartItem cartItem);
	public boolean updateCartItem(CartItem cartItem);
	public List<CartItem> getAllCartItem();
	public List<CartItem> getCartItemsByCart(Cart cart);
	public CartItem getCartItemByCartItemId(int cartItemnId);
	public List<CartItem> getCartItemsByOrderDetails(OrderDetails orderDetails);
	
}
