package com.example.be_smartshopai.Repository;

import com.example.be_smartshopai.Model.Category;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    boolean existsByName(String name);
    Optional<Category> findByName(String name);
}
