package com.loginregistration.controller;


import com.loginregistration.model.User;
import com.loginregistration.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }
}
