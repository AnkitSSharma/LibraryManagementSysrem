package com.example.LibraryManagementSysrem.Services;

import com.example.LibraryManagementSysrem.Entities.User;
import com.example.LibraryManagementSysrem.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void createUser(User user) {
        String unHashedPassword = user.getPassword();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(unHashedPassword);
        user.setPassword(hashedPassword);
        user.setRole(User.type.USER);
        userRepository.save(user);
    }

    public List<User> allUsers() {
        return userRepository.findAll();
    }

    public boolean isValid(String name, String password) {
        User user = userRepository.getByName(name);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(password,user.getPassword());
    }

    public void createAdmin(Long userId) {
        User user = userRepository.getById(userId);
        user.setRole(User.type.ADMIN);
        userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
