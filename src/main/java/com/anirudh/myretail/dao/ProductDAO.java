package com.anirudh.myretail.dao;

import com.anirudh.myretail.model.Money;

public interface ProductDAO {
	
	public Money getProductPrice(Long productId);

}
