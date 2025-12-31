package com.example.be_smartshopai.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ProductDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                   // ID thông số chi tiết sản phẩm

    private String screen;             // Màn hình (kích thước, tần số quét,...)

    private String cpu;                // Bộ vi xử lý (chip điện thoại/laptop)

    private String gpu;                // Card đồ họa (GPU), điện thoại thì GPU chipset

    private String ram;                // Bộ nhớ RAM

    private String storage;            // Bộ nhớ trong (SSD, ROM)

    private String camera;             // Thông số camera (điện thoại)

    private String battery;            // Dung lượng pin

    private String os;                 // Hệ điều hành (iOS, Android, Windows, macOS)

    private String weight;             // Trọng lượng sản phẩm

    private String description;        // Mô tả tổng quan chi tiết sản phẩm

    @OneToOne
    @JoinColumn(name = "product_id", unique = true)
    @JsonBackReference
    @JsonIgnore
    private Product product;


    public ProductDetail() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductDetail(Long id, String screen, String cpu, String gpu, String ram, String storage, String camera, String battery, String os, String weight, String description) {
        this.id = id;
        this.screen = screen;
        this.cpu = cpu;
        this.gpu = gpu;
        this.ram = ram;
        this.storage = storage;
        this.camera = camera;
        this.battery = battery;
        this.os = os;
        this.weight = weight;
        this.description = description;
    }

}
