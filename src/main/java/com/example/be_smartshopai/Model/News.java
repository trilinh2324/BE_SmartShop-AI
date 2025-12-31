package com.example.be_smartshopai.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "news")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Tiêu đề bài viết
    @Column(nullable = false, length = 255)
    private String title;

    // Đường dẫn hình ảnh thumbnail
    private String thumbnail;

    // Nội dung bài viết
    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String content;
    // Ngày tạo
    private LocalDateTime createdAt;
}
