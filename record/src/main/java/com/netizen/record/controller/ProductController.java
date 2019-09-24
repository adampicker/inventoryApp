package com.netizen.record.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.netizen.record.dto.ProductDTO;
import com.netizen.record.model.Product;
import com.netizen.record.repository.CategoryRepository;
import com.netizen.record.repository.ProductRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired CategoryRepository categoryRepository;
	 
    @GetMapping("/products")
    public List<Product> getProducts() {
        return (List<Product>) productRepository.findAll();
    }
    
    @PostMapping("/addproduct")
    public Product addProduct(@RequestBody ProductDTO productToAdd) {    	
    	Product newProduct = productToAdd.mapToProductWithoutCategorySet();
    	newProduct.setCategory(categoryRepository.findById(productToAdd.category_id).orElse(null));
    	return productRepository.save(newProduct);
    }
    
    @PutMapping("/changeproductstatus")
    public Product changeProductStatus(@RequestBody Product productToStatusChange) {
    	productToStatusChange.setEfficent(!productToStatusChange.isEfficent());
    	return productRepository.save(productToStatusChange);
    }
 
   

}
