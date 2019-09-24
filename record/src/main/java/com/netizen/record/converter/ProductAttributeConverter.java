package com.netizen.record.converter;

import java.io.IOException;
import java.util.Map;

import javax.persistence.AttributeConverter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ProductAttributeConverter implements AttributeConverter<Map<String, String>, String> {
	 
	ObjectMapper objectMapper = new ObjectMapper();
	
    @Override
    public String convertToDatabaseColumn(Map<String, String> productAttributes) {
        String customerInfoJson = null;
        try {
            customerInfoJson = objectMapper.writeValueAsString(productAttributes);
        } catch (final JsonProcessingException e) {
            //logger.error("JSON writing error", e);
        }
 
        return customerInfoJson;
    }
 
    @SuppressWarnings("unchecked")
	@Override
    public Map<String, String> convertToEntityAttribute(String productAttributesJSON) {
        Map<String, String> productAttributes = null;
        try {
        	productAttributes = objectMapper.readValue(productAttributesJSON, Map.class);
        } catch (final IOException e) {
            //logger.error("JSON reading error", e);
        }
 
        return productAttributes;
    }

 
}