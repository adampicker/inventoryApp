package com.netizen.record.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.netizen.record.dto.CommentDTO;
import com.netizen.record.model.Product;

@Entity
public class Comment {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	private Product product;
	
	@Column(name = "content")
	private String content;
	
	public Comment() {}
	
	public Comment(String content) {
		this.content = content;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public CommentDTO mapToProductDto() {
		return new CommentDTO(this.id, this.content, this.product.getId());
	}
	
	
	
	
	
	
	

}
