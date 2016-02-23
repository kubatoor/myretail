package com.anirudh.myretail.service;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class TargetAPIServiceImpl implements TargetAPIService {
	
	private static final String BASE_URI="https://api.target.com/products/v3/";
	private static final String URI_PARAMS="?fields=descriptions&id_type=TCIN&key=43cJWpLjH8Z8oR18KdrZDBKAgLLQKJjz";
	private static final String PRODUCT_NAME_NODE="general_description";
	
	@Override
	public String getProductName(Long productID) throws JsonProcessingException, IOException {
		String url = BASE_URI+productID+URI_PARAMS;
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> jsonResponse = restTemplate.getForEntity(url, String.class);
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode root = objectMapper.readTree(jsonResponse.getBody());
		String productName = root.findValue(PRODUCT_NAME_NODE).asText();
		return productName;
	}
	
	
}
