package com.example.be_smartshopai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BeSmartShopAiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeSmartShopAiApplication.class, args);
       System.out.println("http://localhost:8080/api/admin");
    }

}
