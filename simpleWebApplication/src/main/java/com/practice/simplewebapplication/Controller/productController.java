package com.practice.simplewebapplication.Controller;

import com.practice.simplewebapplication.model.Product;
import com.practice.simplewebapplication.service.serviceDataProducts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class productController {

    @Autowired
    serviceDataProducts service;

    @RequestMapping("/products")
    public List<Product> getProduct()
    {
        return service.getProducts();
    }
}
