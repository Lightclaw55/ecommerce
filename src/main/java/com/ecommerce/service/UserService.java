package com.ecommerce.service;

import com.ecommerce.model.User;
import com.ecommerce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepo;

    @Autowired
    public UserService(UserRepository userRepo)
    {
        this.userRepo = userRepo;
    }

    public User getUserByInfo(String username, String password)
    {
        return userRepo.findByUsernameAndPassword(username, password);
    }

    public User getUserById(int id)
    {
        return userRepo.findUserById(id);
    }

    public List<User> getAllUsers()
    {
        return userRepo.findAllUser();
    }

    public User save(User u)
    {
        return userRepo.save(u);
    }



}
