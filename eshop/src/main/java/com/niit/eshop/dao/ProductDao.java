package com.niit.eshop.dao;

import java.util.List;


import com.niit.eshop.model.Product;

public interface ProductDao {
	public List<Product> list();
	public List<Product> listByCategoryId(int categoryId);
	public Product listByProductId(int productId);
	public boolean insertProduct(Product product);
	public List<Product> retreive();
	public Product FindByProductID(int productId);
	public boolean updateProduct(Product product);
	public Object FindByCategoryId(int categoryId);
	public boolean deleteProduct(Product product);
}