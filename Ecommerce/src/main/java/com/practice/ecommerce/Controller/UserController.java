package com.practice.ecommerce.Controller;

import com.practice.ecommerce.Model.User;
import com.practice.ecommerce.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @RequestMapping("/hello")
    public String greet()
    {
        return "Hello, spring security. security bypassed";
    }

    @Autowired
    private UserService service;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user)
    {
        return service.UserRegistration(user);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody User user)
    {
        System.out.println(user);
        return service.verify(user);
    }
}
