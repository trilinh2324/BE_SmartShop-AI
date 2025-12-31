package com.example.be_smartshopai.Service;

import com.example.be_smartshopai.Model.Role;
import com.example.be_smartshopai.Model.User;
import com.example.be_smartshopai.Repository.RoleRepository;
import com.example.be_smartshopai.Repository.UserRepository;
import com.example.be_smartshopai.Request.LoginRequest;
import com.example.be_smartshopai.Request.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User register(RegisterRequest request) {

        if (userRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username đã tồn tại");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        // 🔥 GÁN ROLE_ID = 3
        Role role = roleRepository.findById(3L)
                .orElseThrow(() -> new RuntimeException("Role không tồn tại"));

        user.setRole(role);

        return userRepository.save(user);
    }

    // ĐĂNG NHẬP
    public User login(LoginRequest request) {

        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("Sai tài khoản"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Sai mật khẩu");
        }

        return user;
    }

    // CRUD
    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User update(Long id, RegisterRequest request) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy user"));

        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        return userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
