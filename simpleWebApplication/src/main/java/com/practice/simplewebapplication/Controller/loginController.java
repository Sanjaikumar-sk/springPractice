package com.practice.simplewebapplication.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class loginController {

    @RequestMapping("/login")
    public String login()
    {
        return "Authenticate to acess the page!!...";
    }
}
