package com.netizen.record.dto;

import com.netizen.record.model.Comment;

public class CommentDTO {

	public Long id;	

	public String content;	

	public Long product_id;	
	
    public CommentDTO() {}
    
    public CommentDTO(Long id, String content, Long product_id) {
    	this.id = id;
    	this.content = content;
    	this.product_id = product_id;
    }
    
    public Comment mapToCommentWithoutProductSet() {
    	return new Comment(this.content);
    }    

    
}