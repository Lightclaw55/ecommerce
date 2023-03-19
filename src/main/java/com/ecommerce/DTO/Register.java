package com.ecommerce.DTO;

import com.ecommerce.model.User;

public class Register {

    private String username;
    private String password;
    private User user;

    public Register()
    {

    }

    public Register(String username, String password) {
        this.username = username;
        this.password = password;
        this.user = new User(username, password);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Register{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", user=" + user +
                '}';
    }
}
