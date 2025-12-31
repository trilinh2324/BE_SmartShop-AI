package com.example.be_smartshopai.Controller;

import com.example.be_smartshopai.Model.User;
import com.example.be_smartshopai.Request.LoginRequest;
import com.example.be_smartshopai.Request.RegisterRequest;
import com.example.be_smartshopai.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private UserService userService;

    // ĐĂNG KÝ
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(userService.register(request));
    }

    // ĐĂNG NHẬP
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(userService.login(request));
    }

    // CRUD
    @GetMapping("/users")
    public List<User> getAll() {
        return userService.getAll();
    }

    @PutMapping("/users/{id}")
    public User update(@PathVariable Long id,
                       @RequestBody RegisterRequest request) {
        return userService.update(id, request);
    }

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
}
