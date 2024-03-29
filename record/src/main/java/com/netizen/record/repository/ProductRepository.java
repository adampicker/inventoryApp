package com.netizen.record.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.netizen.record.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
