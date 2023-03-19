package com.ecommerce.controller;

import com.ecommerce.DTO.Login;
import com.ecommerce.DTO.Register;
import com.ecommerce.model.User;
import com.ecommerce.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"}, allowCredentials = "true")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService)
    {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody Login login, HttpSession session)
    {
        User optional = authService.findByCredentials(login.getUsername(), login.getPassword());

        if(optional == null)
        {
            return ResponseEntity.badRequest().build();
        }

        session.setAttribute("user", optional.get());

        return ResponseEntity.ok(optional.get());
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpSession session) {
        session.removeAttribute("user");

        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody Register register) {
        User created = new User(register.getUsername(), register.getPassword());

        return ResponseEntity.status(HttpStatus.CREATED).body(authService.register(created));
    }

}
