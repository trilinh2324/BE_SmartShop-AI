package com.example.be_smartshopai.Request;

import com.example.be_smartshopai.Model.ProductColor;
import com.example.be_smartshopai.Model.ProductDetail;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductCreateRequest {

    private String name;
    private String brand;
    private Double price;
    private Double oldPrice;
    private Double rating;
    private Integer soldQuantity;

    private Long categoryId;
    private String categoryName;
    private ProductDetail productDetail;

    private List<ProductColorRequest> colors;
}
