package com.example.be_smartshopai.Repository;
import com.example.be_smartshopai.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

}