package com.anirudh.myretail.controller;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anirudh.myretail.exception.APIException;
import com.anirudh.myretail.model.Product;
import com.anirudh.myretail.service.ProductService;

/**
 * 
 * @author anirudh
 * This is the main Product controller class which maps incoming requests
 * to controller methods and in turn calls the service methods to get 
 * Product details or update Product price
 */
@RestController
public class ProductController {
	
    @Autowired
	private ProductService productService;
	
	@RequestMapping("/product/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable("id") @NotEmpty Long productId){
		
		Product product = productService.getProduct(productId);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/product/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Product> updateProduct(@PathVariable("id") Long productId, 
			@RequestBody Product product){
	
		productService.updateProduct(product);
		return new ResponseEntity<Product>(HttpStatus.OK);
		
	}
	
	@ExceptionHandler(APIException.class)
	public ResponseEntity<String> handleAPIException(){
		String message = "Internal Server Error";
		return new ResponseEntity<>(message,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> handleInvalidRequests(){
		
		String message = "Invalid Request";
		return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		
	}

}
