package com.example.be_smartshopai.Service.Categorys;

import com.example.be_smartshopai.Model.Category;
import com.example.be_smartshopai.Repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    // ✅ Lấy tất cả category
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }
    public Category getById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy danh mục"));
    }

    // ✅ Thêm category
    public Category create(Category category) {
        if (categoryRepository.existsByName(category.getName())) {
            throw new RuntimeException("Tên danh mục đã tồn tại");
        }
        return categoryRepository.save(category);
    }

    // ✅ Sửa category
    public Category update(Long id, Category data) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy danh mục"));

        // check trùng tên (nâng cao)
        if (!category.getName().equals(data.getName())
                && categoryRepository.existsByName(data.getName())) {
            throw new RuntimeException("Tên danh mục đã tồn tại");
        }

        category.setName(data.getName());
        return categoryRepository.save(category);
    }

    // ✅ Xóa category
    public void delete(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy danh mục"));

        // ⚠️ Không cho xóa nếu còn sản phẩm
        if (category.getProducts() != null && !category.getProducts().isEmpty()) {
            throw new RuntimeException("Không thể xóa danh mục đang có sản phẩm");
        }

        categoryRepository.delete(category);
    }
}
