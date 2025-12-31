package com.example.be_smartshopai.Service;

import com.example.be_smartshopai.Model.Category;
import com.example.be_smartshopai.Model.Product;
import com.example.be_smartshopai.Repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    public List<Category> getAllProducts() {
        return categoryRepository.findAll();
    }

}
