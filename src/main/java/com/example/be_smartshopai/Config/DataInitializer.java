package com.example.be_smartshopai.Config;

import com.example.be_smartshopai.Model.User;
import com.example.be_smartshopai.Model.Role;
import com.example.be_smartshopai.Enums.UserStatus;
import com.example.be_smartshopai.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {

        if (!userRepository.existsByUsername("admin")) {
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("123456"));
            admin.setEmail("admin@gmail.com");
            admin.setRole(Role.ADMIN);
            admin.setStatus(UserStatus.ACTIVE);

            userRepository.save(admin);

            System.out.println("✅ ADMIN account created: admin / 123456");
        }
    }

}
