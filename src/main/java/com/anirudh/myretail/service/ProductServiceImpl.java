package com.anirudh.myretail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anirudh.myretail.dto.ProductDTO;
import com.anirudh.myretail.model.Currency;
import com.anirudh.myretail.model.Money;
import com.anirudh.myretail.model.Product;
import com.anirudh.myretail.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product getProduct(Long productId) {
		
		ProductDTO productDTO =  productRepository.findByProductId(productId);
		
		Product product = new Product();
		product.setId(productId);
		product.setName("Iphone 678");
		Money money = new Money(productDTO.getPrice(), Currency.valueOf(productDTO.getCurrency()));
		product.setPrice(money);
		return product;
	}

	@Override
	public void updateProduct(Product product) {
		/*ProductDTO productDTO = new ProductDTO();
		productDTO.setProductID(product.getId());
		productDTO.setCurrency(product.getPrice().getCurrency().getCurrencyValue());
		productDTO.setPrice(product.getPrice().getAmount());*/
		productRepository.update(product.getPrice().getAmount(),
				product.getPrice().getCurrency().getCurrencyValue(),
				product.getId());
		return;
		
	}

}
