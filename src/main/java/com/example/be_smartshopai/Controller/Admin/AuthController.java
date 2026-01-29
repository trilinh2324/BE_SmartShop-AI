//package com.example.be_smartshopai.Controller.Admin;
//
//
//import com.example.be_smartshopai.Enums.UserStatus;
//import com.example.be_smartshopai.Model.Role;
//import com.example.be_smartshopai.Model.User;
//import com.example.be_smartshopai.Repository.AdminRepository;
//import com.example.be_smartshopai.Repository.UserRepository;
//import com.example.be_smartshopai.Request.LoginRequest;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/auth")
//@CrossOrigin("*")
//@RequiredArgsConstructor
//public class AuthController {
//
//    private final AdminRepository adminRepository;
//    private final PasswordEncoder passwordEncoder;
//
//    @PostMapping("/admin/login")
//    public User adminLogin(@RequestBody LoginRequest request) {
//
//        User user = adminRepository.findByUsername(request.getUsername())
//                .orElseThrow(() -> new RuntimeException("Sai tài khoản hoặc mật khẩu"));
//
//        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
//            throw new RuntimeException("Sai tài khoản hoặc mật khẩu");
//        }
//
//        // ❌ CHỈ ADMIN
//        if (user.getRole() != Role.ADMIN) {
//            throw new RuntimeException("Bạn không có quyền ADMIN");
//        }
//
//        // ❌ ADMIN bị block
//        if (user.getStatus() == UserStatus.BLOCKED) {
//            throw new RuntimeException("Tài khoản ADMIN đã bị khoá");
//        }
//
//        // ❗ Không trả password về FE
//        user.setPassword(null);
//
//        return user;
//    }
//}
