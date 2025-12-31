package com.example.be_smartshopai.Controller.Products;

import com.example.be_smartshopai.Model.Product;
import com.example.be_smartshopai.Request.ProductCreateRequest;
import com.example.be_smartshopai.Request.ProductUpdateRequest;
import com.example.be_smartshopai.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody ProductCreateRequest request) {
        productService.createProduct(request);
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/{id}")
    public Product detail(@PathVariable Long id) {
        return productService.getDetail(id);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable Long id,
                          @RequestBody ProductUpdateRequest request) {
        return productService.updateProduct(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok("Deleted successfully");
    }
}
