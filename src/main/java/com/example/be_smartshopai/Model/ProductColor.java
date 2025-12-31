package com.example.be_smartshopai.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class ProductColor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String colorName; // màu sản phẩm

    private String image; // ảnh sản phẩm

    private int quantity; // số lượng sản phẩm

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference
    @JsonIgnore
    private Product product;

    public String getImagePath() {
        return "/Image/" + image;
    }




    public void setProduct(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getColorName() {
        return colorName;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
