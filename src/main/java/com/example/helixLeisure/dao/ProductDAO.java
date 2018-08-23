package com.example.helixLeisure.dao;

import com.example.helixLeisure.model.Product;

public interface ProductDAO {

	public void save(Product product);
	public Product find(long id);
	
}
