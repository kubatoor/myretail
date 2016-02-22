package com.anirudh.myretail.model;

public enum Currency {
	
	USD("USD"),GBP("GBP"),INR("INR");
	
	private String value;
	
	private Currency(String value){
		this.value = value;
	}
	
	public String getCurrencyValue(){
		return value;
	}

}
