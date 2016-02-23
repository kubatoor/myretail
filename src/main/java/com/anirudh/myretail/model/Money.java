package com.anirudh.myretail.model;

import java.math.BigDecimal;

import javax.validation.constraints.Digits;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Money {
	@JsonProperty("value")
	@Digits(fraction = 0, integer = 0)
	private BigDecimal amount;
	@JsonProperty("currency_code")
	private Currency currency;
	
	public Money(){
		
	}
		
	public Money(BigDecimal amount, Currency currency){
		this.amount = amount;
		this.currency = currency;
	}
	
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	};

}
