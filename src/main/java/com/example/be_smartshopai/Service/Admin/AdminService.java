//package com.example.be_smartshopai.Service.Admin;
//
//
//import com.example.be_smartshopai.Enums.UserStatus;
//import com.example.be_smartshopai.Model.Role;
//import com.example.be_smartshopai.Model.User;
//import com.example.be_smartshopai.Repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class AdminService {
//
//    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
//
//    // ADMIN: xem tất cả user
//    public List<User> getAllUsers() {
//        return userRepository.findAll();
//    }
//
//    // ADMIN: tạo user mới
//    public User createUser(User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        user.setStatus(UserStatus.ACTIVE);
//        if (user.getRole() == null) {
//            user.setRole(Role.USER);
//        }
//        return userRepository.save(user);
//    }
//
//    // ADMIN: sửa user
//    public User updateUser(Long id, User newUser) {
//        User user = userRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("User not found"));
//
//        user.setEmail(newUser.getEmail());
//        user.setPhone_number(newUser.getPhone_number());
//        user.setGender(newUser.getGender());
//        user.setAddress(newUser.getAddress());
//        user.setRole(newUser.getRole());
//
//        return userRepository.save(user);
//    }
//
//    // ADMIN: block user
//    public User blockUser(Long id) {
//        User user = userRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("User not found"));
//
//        user.setStatus(UserStatus.BLOCKED);
//        return userRepository.save(user);
//    }
//
//    // ADMIN: mở block user
//    public User unblockUser(Long id) {
//        User user = userRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("User not found"));
//
//        user.setStatus(UserStatus.ACTIVE);
//        return userRepository.save(user);
//    }
//
//    // ADMIN: xoá user
//    public void deleteUser(Long id) {
//        userRepository.deleteById(id);
//    }
//}
