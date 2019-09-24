package com.netizen.record.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.netizen.record.model.Category;
import com.netizen.record.repository.CategoryRepository;


@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class CategoryController {
	
	@Autowired
	private CategoryRepository categoryRepository;
	 
    @GetMapping("/categories")
    public List<Category> getCategories() {
        return (List<Category>) categoryRepository.findAll();
    }
    
    @PostMapping("/addcategory")
    public Category addCategory(@RequestBody Category categoryToAdd) {    	
    	Category newCategory = new Category(categoryToAdd.getCategoryName());
    	return categoryRepository.save(newCategory);// returning category with id
    }

}
