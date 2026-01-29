package com.example.be_smartshopai.Enums;


public enum OrderStatus {
    PENDING_CONFIRMATION, // chờ admin xác nhận
    CONFIRMED,            // admin đã xác nhận
    SHIPPING,             // đang giao
    DELIVERED,            // user xác nhận đã nhận hàng
    COMPLETED,            // admin xác nhận hoàn tất
    CANCELLED             // hủy đơn
}