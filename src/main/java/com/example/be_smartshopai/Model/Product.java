package com.example.be_smartshopai.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // ID sản phẩm
    @Column(unique = true)
    private String name;             // Tên sản phẩm (VD: iPhone 15 Pro, MacBook M3)

    private String brand;            // Thương hiệu (Apple, Samsung, Dell,...)

    private Double price;            // Giá bán hiện tại

    private Double oldPrice;         // Giá cũ (dùng để hiển thị giảm giá)

    private Double rating;           // Điểm đánh giá trung bình

    private LocalDateTime createdAt; // Ngày thêm sản phẩm

    private LocalDateTime updatedAt; // Ngày cập nhật sản phẩm

    private Integer soldQuantity;      // Số lượng sản phẩm đã bán

    @Transient
    private String formattedPrice; // fomart lại giá

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonIgnoreProperties({"products"}) // tránh loop
    private Category category;




    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductColor> colors;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "product_detail_id")
    private ProductDetail productDetail;

    public String getFormattedPrice() {
        DecimalFormat df = new DecimalFormat("#,###");
        return df.format(price);
    }

    // Ensure the image path is relative to the static directory

    public Product() {
    }

    public Product(Long id, String name, String brand, Double price, Double oldPrice, Double rating, LocalDateTime createdAt, LocalDateTime updatedAt, Integer soldQuantity, Category category, ProductDetail productDetail, String formattedPrice) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.oldPrice = oldPrice;
        this.rating = rating;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.soldQuantity = soldQuantity;
        this.category = category;
        this.productDetail = productDetail;
        this.formattedPrice = formattedPrice;
    }

}
