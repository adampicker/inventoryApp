package com.netizen.record.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.netizen.record.dto.CommentDTO;
import com.netizen.record.model.Comment;
import com.netizen.record.repository.CommentRepository;
import com.netizen.record.repository.ProductRepository;


@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class CommentController {
	
	@Autowired
	private CommentRepository commentRepository;

	@Autowired ProductRepository productReposiory;
	
	
	@GetMapping("/getallcomments")
    public List<CommentDTO> getComments() {
		List<CommentDTO> allCommentsToSend = new LinkedList<>();
        commentRepository.findAll().forEach(comment -> {
        	allCommentsToSend.add(comment.mapToProductDto());
        });
        return allCommentsToSend;
    }
	
	@PostMapping("/addcomment")
	public Comment addComment(@RequestBody CommentDTO commentToAdd) {
		Comment newComment = commentToAdd.mapToCommentWithoutProductSet();
		newComment.setProduct(productReposiory.findById(commentToAdd.product_id).orElse(null));
		return commentRepository.save(newComment);		
	}

}
