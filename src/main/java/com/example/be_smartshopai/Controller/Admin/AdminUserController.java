//package com.example.be_smartshopai.Controller.Admin;
//
//import com.example.be_smartshopai.Model.User;
//import com.example.be_smartshopai.Service.Admin.AdminService;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/admin")
//@CrossOrigin("*")
//@RequiredArgsConstructor
//public class AdminUserController {
//
//    private final AdminService adminService;
//
//    // Xem danh sách user
//    @GetMapping
//    public List<User> getAllUsers() {
//        return adminService.getAllUsers();
//    }
//
//    // Tạo user
//    @PostMapping
//    public User createUser(@RequestBody User user) {
//        return adminService.createUser(user);
//    }
//
//    // Sửa user
//    @PutMapping("/{id}")
//    public User updateUser(@PathVariable Long id, @RequestBody User user) {
//        return adminService.updateUser(id, user);
//    }
//
//    // Block user
//    @PutMapping("/{id}/block")
//    public User blockUser(@PathVariable Long id) {
//        return adminService.blockUser(id);
//    }
//
//    // Mở block user
//    @PutMapping("/{id}/unblock")
//    public User unblockUser(@PathVariable Long id) {
//        return adminService.unblockUser(id);
//    }
//
//    // Xoá user
//    @DeleteMapping("/{id}")
//    public void deleteUser(@PathVariable Long id) {
//        adminService.deleteUser(id);
//    }
//}
