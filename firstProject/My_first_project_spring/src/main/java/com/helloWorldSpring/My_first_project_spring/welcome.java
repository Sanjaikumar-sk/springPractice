package com.helloWorldSpring.My_first_project_spring;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class welcome {
    @RequestMapping("/")
    public String hello(){
        return "My first spring code" ;
    }
}
