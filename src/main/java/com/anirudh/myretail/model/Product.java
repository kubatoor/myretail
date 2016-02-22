package com.anirudh.myretail.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Product {
	
	
	private Long id;
	
	private String name;
	
	@JsonProperty("current_price")
	private Money price;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Money getPrice() {
		return price;
	}
	public void setPrice(Money price) {
		this.price = price;
	}
	

}
