package com.example.be_smartshopai.Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductColorRequest {

    private String colorName;
    private String image; // "/uploads/products/xxx.png"
    private Integer quantity;
}
