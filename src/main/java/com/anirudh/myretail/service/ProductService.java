package com.anirudh.myretail.service;

import com.anirudh.myretail.model.Product;

public interface ProductService {
	
	public Product getProduct(Long productId);
	
	public void updateProduct(Product product);

}
