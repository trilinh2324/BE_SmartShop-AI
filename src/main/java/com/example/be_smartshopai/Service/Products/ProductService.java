package com.example.be_smartshopai.Service.Products;

import com.example.be_smartshopai.Model.*;
import com.example.be_smartshopai.Repository.*;
import com.example.be_smartshopai.Request.ProductColorRequest;
import com.example.be_smartshopai.Request.ProductCreateRequest;
import com.example.be_smartshopai.Request.ProductUpdateRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    // =========================
    // CHECK TRÙNG TÊN (FE dùng)
    // =========================
    public boolean checkNameExists(String name) {
        return productRepository.existsByNameIgnoreCase(name);
    }

    // =========================
    // GET ALL
    // =========================
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // =========================
    // CREATE PRODUCT (CHẶN TRÙNG TÊN)
    // =========================
    public Product createProduct(ProductCreateRequest request) {

        // ❌ TRÙNG TÊN
        if (productRepository.existsByNameIgnoreCase(request.getName())) {
            throw new RuntimeException("❌ Tên sản phẩm đã tồn tại");
        }

        Category category = categoryRepository.findByName(request.getCategoryName())
                .orElseThrow(() ->
                        new RuntimeException("Category not found: " + request.getCategoryName())
                );

        Product product = new Product();
        product.setName(request.getName());
        product.setBrand(request.getBrand());
        product.setPrice(request.getPrice());
        product.setOldPrice(request.getOldPrice());
        product.setRating(request.getRating());
        product.setSoldQuantity(request.getSoldQuantity());
        product.setCategory(category);
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());

        // =========================
        // PRODUCT DETAIL
        // =========================
        if (request.getProductDetail() != null) {
            ProductDetail detail = request.getProductDetail();
            detail.setProduct(product);
            product.setProductDetail(detail);
        }

        // =========================
        // PRODUCT COLORS
        // =========================
        if (request.getColors() != null && !request.getColors().isEmpty()) {

            List<ProductColor> colors = new ArrayList<>();

            for (ProductColorRequest c : request.getColors()) {

                if (c.getImage() == null || c.getImage().isBlank()) {
                    throw new RuntimeException("Color image is required");
                }

                ProductColor color = new ProductColor();
                color.setColorName(c.getColorName());
                color.setQuantity(c.getQuantity());
                color.setImage(c.getImage());
                color.setProduct(product);

                colors.add(color);
            }

            product.setColors(colors);
        }

        return productRepository.save(product);
    }

    // =========================
    // GET DETAIL
    // =========================
    public Product getDetail(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    // =========================
    // UPDATE PRODUCT (CHẶN TRÙNG TÊN)
    // =========================
    public Product updateProduct(Long id, ProductUpdateRequest request) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        // ❌ TRÙNG TÊN (KHÁC ID)
        if (!product.getName().equalsIgnoreCase(request.getName())
                && productRepository.existsByNameIgnoreCase(request.getName())) {
            throw new RuntimeException("❌ Tên sản phẩm đã tồn tại");
        }
        product.setName(request.getName());
        product.setBrand(request.getBrand());
        product.setPrice(request.getPrice());
        product.setOldPrice(request.getOldPrice());
        product.setRating(request.getRating());
        product.setSoldQuantity(request.getSoldQuantity());
        product.setUpdatedAt(LocalDateTime.now());

        // =========================
        // UPDATE PRODUCT DETAIL
        // =========================
        if (request.getProductDetail() != null) {

            ProductDetail detail = product.getProductDetail();

            if (detail == null) {
                detail = request.getProductDetail();
                detail.setProduct(product);
                product.setProductDetail(detail);
            } else {
                detail.setScreen(request.getProductDetail().getScreen());
                detail.setCpu(request.getProductDetail().getCpu());
                detail.setGpu(request.getProductDetail().getGpu());
                detail.setRam(request.getProductDetail().getRam());
                detail.setStorage(request.getProductDetail().getStorage());
                detail.setCamera(request.getProductDetail().getCamera());
                detail.setBattery(request.getProductDetail().getBattery());
                detail.setOs(request.getProductDetail().getOs());
                detail.setWeight(request.getProductDetail().getWeight());
                detail.setDescription(request.getProductDetail().getDescription());
            }
        }

        // =========================
        // UPDATE COLORS
        // =========================
        if (request.getColors() != null) {

            product.getColors().clear();

            for (ProductColor c : request.getColors()) {

                if (c.getImage() == null || c.getImage().isBlank()) {
                    throw new RuntimeException("Color image is required");
                }

                c.setProduct(product);
                product.getColors().add(c);
            }
        }

        return productRepository.save(product);
    }

    // =========================
    // DELETE PRODUCT
    // =========================
    @Transactional
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        productRepository.delete(product);
    }
}










