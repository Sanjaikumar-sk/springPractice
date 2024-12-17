package com.practice.simplewebapplication.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class homeController {

    @RequestMapping("/")
    public String home()
    {
        return "Welcome to Simple Web Application done by me";
    }

    @RequestMapping("/about")
    public String about()
    {
        return "This is a simple web application to practice spring and back en data management.";
    }
}
