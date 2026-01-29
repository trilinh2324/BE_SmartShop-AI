package com.example.be_smartshopai.Controller.Products;

import com.example.be_smartshopai.Model.Category;
import com.example.be_smartshopai.Service.Categorys.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin("*")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    // ✅ Lấy tất cả category
    @GetMapping
    public List<Category> getAll() {
        return categoryService.getAll();
    }
    @GetMapping("/{id}")
    public Category getById(@PathVariable Long id) {
        return categoryService.getById(id);
    }
    // ✅ Thêm category
    @PostMapping
    public Category create(@RequestBody Category category) {
        return categoryService.create(category);
    }

    // ✅ Sửa category
    @PutMapping("/{id}")
    public Category update(
            @PathVariable Long id,
            @RequestBody Category category
    ) {
        return categoryService.update(id, category);
    }

    // ✅ Xóa category
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        categoryService.delete(id);
    }
}
