package com.niit.ecart.dao;

import java.util.List;


import com.niit.ecart.model.Product;

public interface ProductDao {
	public List<Product> list();
	public List<Product> listByCategoryId(int categoryId);
	public Product listByProductId(int productId);
}
