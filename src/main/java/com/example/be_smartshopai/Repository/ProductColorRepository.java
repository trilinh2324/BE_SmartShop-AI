package com.example.be_smartshopai.Repository;

import com.example.be_smartshopai.Model.Product;
import com.example.be_smartshopai.Model.ProductColor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductColorRepository extends JpaRepository<ProductColor, Long> {
    List<ProductColor> findByProductId(Long productId);
    void deleteByProduct(Product product);}
