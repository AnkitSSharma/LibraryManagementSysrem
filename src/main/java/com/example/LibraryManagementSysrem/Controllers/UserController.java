package com.example.LibraryManagementSysrem.Controllers;

import com.example.LibraryManagementSysrem.Entities.User;
import com.example.LibraryManagementSysrem.Services.UserService;
import com.example.LibraryManagementSysrem.Util.JwtUtil;
import com.example.LibraryManagementSysrem.Util.MyUserDetailImpl;
import com.example.LibraryManagementSysrem.Util.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class UserController {
    @Autowired
    private UserService service;
    @Autowired
    private MyUserDetailService userDetailService;

    private AuthenticationManager manager;

    @Autowired
    private JwtUtil jwtUtil;


    @GetMapping("/user/authenticate")
    public ResponseEntity<String> isValid(@RequestParam("name") String name, @RequestParam("password") String password){
        if(service.isValid(name,password)) {
            UserDetails userDetails = userDetailService.loadUserByUsername(name);
            String jwt = jwtUtil.generateToken((MyUserDetailImpl) userDetails);
            return ResponseEntity.ok(jwt);
        }
        else
            return ResponseEntity.ok("UnAuthenticated User");
    }
    @PostMapping("/user/signUp")
    void createUser(@RequestBody User user){
        service.createUser(user);
    }

    @GetMapping("/admin/create")
    void createAdmin(@RequestParam("userId") Long userId){
        service.createAdmin(userId);
    }
    @GetMapping("/admin/allusers")
    List<User> getAllUsers(){
        return service.getAllUsers();
    }
}
