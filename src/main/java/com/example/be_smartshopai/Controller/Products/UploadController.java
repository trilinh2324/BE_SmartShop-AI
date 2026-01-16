package com.example.be_smartshopai.Controller.Products;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;

@RestController
@RequestMapping("/api/uploads")
@CrossOrigin(origins = "*")
public class UploadController {

    private static final String UPLOAD_DIR = "uploads/products";

    // ================= UPLOAD ẢNH PRODUCT =================
    @PostMapping("/products")
    @ResponseStatus(HttpStatus.OK)
    public String uploadProductImage(
            @RequestParam("file") MultipartFile file
    ) throws IOException {

        if (file.isEmpty()) {
            throw new RuntimeException("File rỗng");
        }

        // 🔒 Chỉ cho phép ảnh
        String contentType = file.getContentType();
        if (contentType == null || !contentType.startsWith("image/")) {
            throw new RuntimeException("Chỉ được upload file ảnh");
        }

        // 📌 Tạo thư mục nếu chưa có
        Path uploadPath = Paths.get(UPLOAD_DIR);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        // 📛 Tên file an toàn
        String fileName = System.currentTimeMillis() + "_" +
                file.getOriginalFilename().replaceAll("\\s+", "_");

        Path filePath = uploadPath.resolve(fileName);

        // 💾 Lưu file
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        // ✅ FRONTEND CHỜ STRING NÀY
        return "/uploads/products/" + fileName;
    }
}
