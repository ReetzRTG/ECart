package com.niit.ecart.dao;

import java.util.List;

import com.niit.ecart.model.OrderDetails;
import com.niit.ecart.model.User;

public interface OrderDetailsDao {

	
	public OrderDetails getOrderDetailsByOrderDetailsId(int orderDetails);
	public boolean updateOrderDetails(OrderDetails orderDetails);
	public boolean deleteOrderDetails(OrderDetails orderDetails);
	public boolean insertOrderDetails(OrderDetails orderDetails);
	public List<OrderDetails> getOrderDetailsListByUser (User user);
}
