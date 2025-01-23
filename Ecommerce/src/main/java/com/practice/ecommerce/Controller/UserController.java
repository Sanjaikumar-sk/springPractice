package com.practice.ecommerce.Controller;

import com.practice.ecommerce.Model.User;
import com.practice.ecommerce.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user)
    {
        return service.UserRegistration(user);
    }
}
