package com.netizen.record.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.netizen.record.model.Product;

@Entity
public class Category {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "category_name")
	private String categoryName;
	
	public Category() {}
	
	public Category(String name) {
		this.categoryName = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	
	//@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    //private Set<Product> products;
	
}
