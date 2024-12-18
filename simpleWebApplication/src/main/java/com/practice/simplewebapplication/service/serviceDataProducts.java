package com.practice.simplewebapplication.service;

import com.practice.simplewebapplication.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class serviceDataProducts {

    List<Product> Products= new ArrayList<>( Arrays.asList(new Product(101,"Iphone", 100)));
    public List<Product> getProducts()
    {
        return Products;
    }


    public Product getProductbyID( int prodID)
    {
        return Products.stream()
                .filter(p -> p.getProductID() == prodID)
                .findFirst().orElse(new Product(404, "Not found", 0));
    }

    public void addProduct(Product product)
    {
        System.out.println(product);
        Products.add(product);
    }
}
