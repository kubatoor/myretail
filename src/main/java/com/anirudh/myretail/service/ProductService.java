package com.anirudh.myretail.service;

import com.anirudh.myretail.exception.APIException;
import com.anirudh.myretail.model.Product;

public interface ProductService {
	
	public Product getProduct(Long productId) throws APIException;
	
	public void updateProduct(Product product) throws APIException;

}
