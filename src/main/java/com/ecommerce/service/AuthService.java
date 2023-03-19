package com.ecommerce.service;

import com.ecommerce.model.User;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthService {

    private final UserService userService;

    @Autowired
    public AuthService(UserService userService)
    {
        this.userService = userService;
    }

    public User findByCredentials(String username, String password)
    {
        return userService.getUserByInfo(username, password);
    }

    public User register(User u)
    {
        return userService.save(u);
    }
}
