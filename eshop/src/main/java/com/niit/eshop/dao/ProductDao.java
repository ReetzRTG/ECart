package com.niit.eshop.dao;

import java.util.List;


import com.niit.eshop.model.Product;

public interface ProductDao {
	public List<Product> list();
	public List<Product> listByCategoryId(int categoryId);
	public Product listByProductId(int productId);
}