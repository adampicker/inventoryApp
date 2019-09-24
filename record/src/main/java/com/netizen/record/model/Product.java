package com.netizen.record.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.netizen.record.converter.ProductAttributeConverter;

import com.netizen.record.model.Category;

@Entity
public class Product {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "is_efficent")
	private boolean isEfficent;
	
	@Convert(converter = ProductAttributeConverter.class)
	@Column(name = "attributes")
	private Map<String, String> attributes;
	
	@ManyToOne
    private Category category;
	
	public Product() {}
	
	public Product(ProductBuilder builder) {
		this.name = builder.name;
		this.category = builder.category;
		this.attributes = builder.attributes;
		this.isEfficent = builder.isEfficient;
	}
	
	public static class ProductBuilder{
		
		private String name;
		private boolean isEfficient;
		private Map<String, String> attributes =  new HashMap<String,String>();
		private Category category;
		
		public ProductBuilder setName(String name) {
			this.name = name;
			return this;
		}
		
		public ProductBuilder setCategory(Category category) {
			this.category = category;
			return this;
		}
		
		public ProductBuilder setEfficiency(boolean isEfficient) {
			this.isEfficient = isEfficient;
			return this;
		}
		
		public ProductBuilder setAttributes(Map<String,String> attributes) {
			this.attributes = attributes;
			return this;
		}
		
		public ProductBuilder setAttribute(String key, String value) {
			this.attributes.put(key, value);
			return this;
		}
		
		public Product build() {
			return new Product(this);
		}
	}

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

	public boolean isEfficent() {
		return isEfficent;
	}

	public void setEfficent(boolean isEfficent) {
		this.isEfficent = isEfficent;
	}

	public Map<String, String> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	
	
	
	

}
