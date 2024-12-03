package com.firstproject.helloworld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class welcome {
    @RequestMapping("/")
    public String initiator()
    {
        return ("Hellow world");
    }
}
