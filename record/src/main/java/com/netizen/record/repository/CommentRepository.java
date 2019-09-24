package com.netizen.record.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.netizen.record.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
