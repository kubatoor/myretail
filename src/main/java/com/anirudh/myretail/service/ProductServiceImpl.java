package com.anirudh.myretail.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anirudh.myretail.dto.ProductDTO;
import com.anirudh.myretail.exception.APIException;
import com.anirudh.myretail.model.Currency;
import com.anirudh.myretail.model.Money;
import com.anirudh.myretail.model.Product;
import com.anirudh.myretail.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private TargetAPIService targetAPIService;

	@Override
	public Product getProduct(Long productId) throws APIException{
		
		Product product = new Product();
		
		try {
			
			ProductDTO productDTO =  productRepository.findByProductId(productId);
			product.setId(productId);
			product.setName(targetAPIService.getProductName(productId));
			Money money = new Money(productDTO.getPrice(), Currency.valueOf(productDTO.getCurrency()));
			product.setPrice(money);
		} catch (Exception ex){
			throw new APIException(ex.getMessage(), ex);
		}
		
		return product;
	}

	@Override
	public void updateProduct(Product product) throws APIException {
		
		try{
			
			productRepository.update(product.getPrice().getAmount(),
					product.getPrice().getCurrency().getCurrencyValue(),
					product.getId());
			
		} catch(Exception ex){
			throw new APIException(ex.getMessage(), ex);
		}
		
	}

}
