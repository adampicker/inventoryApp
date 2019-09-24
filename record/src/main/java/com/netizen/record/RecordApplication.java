package com.netizen.record;

import java.util.Arrays;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.netizen.record.model.Category;
import com.netizen.record.model.Product;
import com.netizen.record.repository.CategoryRepository;
import com.netizen.record.repository.ProductRepository;

@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class}
        )
public class RecordApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(RecordApplication.class, args);
	}
	
	/*@Bean
    CommandLineRunner init(ProductRepository productRepository, CategoryRepository categoryRepository) {
        return args -> {
           Category c1 = categoryRepository.save(new Category("electronics"));
           Category c2 = categoryRepository.save(new Category("phones"));
           Category c3 = categoryRepository.save(new Category("washer"));
           
           Product p1 = new Product.ProductBuilder().setName("phone 6s")
        		   .setCategory(c1)
        		   .setEfficiency(true)
        		   .setAttribute("color", "jet black")
        		   .setAttribute("Size", "64GB")
        		   .build();
           
           Product p2 = new Product.ProductBuilder().setName("mac book")
        		   .setCategory(c2)
        		   .setEfficiency(true)
        		   .build();
           Product p3 = new Product.ProductBuilder().setName("dish washer")
        		   .setCategory(c3)
        		   .setEfficiency(false)
        		   .setAttribute("energetic class", "AAA+")
        		   .build();
           
           productRepository.saveAll(Arrays.asList(p1, p2, p3));
        		   
           
        };
    }
	*/
	

}
