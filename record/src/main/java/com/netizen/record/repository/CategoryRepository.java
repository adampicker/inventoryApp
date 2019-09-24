package com.netizen.record.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.netizen.record.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
