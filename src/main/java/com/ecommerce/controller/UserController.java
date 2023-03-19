package com.ecommerce.controller;

import com.ecommerce.DTO.Login;
import com.ecommerce.DTO.Register;
import com.ecommerce.model.User;
import com.ecommerce.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class UserController {

    private final UserService userService;

    public UserController(UserService uS)
    {
        this.userService = uS;
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody Login login)
    {
        User u = userService.getUserByInfo(login.getUsername(), login.getPassword());
        return ResponseEntity.ok(u);
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody Register register)
    {
        User u = userService.save(register.getUser());
        return ResponseEntity.ok(u);
    }
}
