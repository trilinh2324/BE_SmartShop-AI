package com.example.be_smartshopai.Model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductDTO {
    private long id;
    private long idCategory;
    private Category category;
    private List<Product> products;
    private ProductDetail productDetail;
    private ProductColor productColor;
    public ProductDTO(long id, long idCategory, Category category, List<Product> products, ProductDetail productDetail,ProductColor productColor) {
        this.id = id;
        this.idCategory = idCategory;
        this.category = category;
        this.products = products;
        this.productDetail = productDetail;
        this.productColor = productColor;
    }

    public ProductDTO(Category category, List<Product> products, ProductDetail productDetail,ProductColor productColor) {
        this.idCategory = category.getId();
        this.category = category;
        this.products = products;
        this.productDetail = productDetail;
        this.productColor =productColor;
    }

    public ProductColor getProductColor() {
        return productColor;
    }

    public void setProductColor(ProductColor productColor) {
        this.productColor = productColor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(long idCategory) {
        this.idCategory = idCategory;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public ProductDetail getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(ProductDetail productDetail) {
        this.productDetail = productDetail;
    }

}
