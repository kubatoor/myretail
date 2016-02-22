package com.anirudh.myretail.service;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface TargetAPIService {
	
	public String getProductName(Long productID) throws JsonProcessingException, IOException;

}
