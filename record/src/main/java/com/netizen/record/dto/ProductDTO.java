package com.netizen.record.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.netizen.record.model.Product;



public class ProductDTO {

	public Long id;	

	public String name;	

	public boolean isEfficent;	

	public List<AttributeDTO> attributes;	
	
    public long category_id;
    
    public ProductDTO() {}

    
    public Product mapToProductWithoutCategorySet() {
    	return new Product.ProductBuilder()
    			.setName(this.name)
    			.setEfficiency(true)
    			.setAttributes(this.getMappedAttributes())
    			.build();
    }
    

    
	private Map<String, String> getMappedAttributes(){
		Map<String,String> attributes = new HashMap<String,String>();
    	if (this.attributes.size() > 0) this.attributes.forEach(x -> {
    		attributes.put(x.key, x.value);
    	});
    	return attributes;
	}
	

}
