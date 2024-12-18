package com.practice.simplewebapplication.service;

import com.practice.simplewebapplication.model.Product;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class serviceDataProducts {



    public List<Product> getProducts()
    {
        List<Product> Products= Arrays.asList(new Product(101,"Iphone", 100));

        return Products;
    }
}
