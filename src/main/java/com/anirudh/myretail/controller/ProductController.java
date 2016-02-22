package com.anirudh.myretail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anirudh.myretail.model.Product;
import com.anirudh.myretail.service.ProductService;

@RestController
public class ProductController {
	
    @Autowired
	private ProductService productService;
	
	@RequestMapping("/product/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable("id") Long productId){
		
		Product product = productService.getProduct(productId);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/product/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Product> updateProduct(@PathVariable("id") Long productId, @RequestBody Product product){

		productService.updateProduct(product);
		return new ResponseEntity<Product>(HttpStatus.OK);
		
	}

}
