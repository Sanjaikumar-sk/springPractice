package com.practice.simplewebapplication.service;

import com.practice.simplewebapplication.Repo.ProductRepo;
import com.practice.simplewebapplication.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class serviceDataProducts {

    @Autowired
    ProductRepo repo;
//    List<Product> Products= new ArrayList<>( Arrays.asList(new Product(101,"Iphone", 100)));
//    TO GET ALL THE PRODUCTS
    public List<Product> getProducts()
    {
        return repo.findAll();
    }

//TO GET A PRODUCT BASED ON PRODUCT ID
    public Product getProductbyID( int prodID)
    {
        return repo.findById(prodID).orElse(new Product());
    }

//TO ADD A NEW VALUE
    public void addProduct(Product product)
    {
        repo.save(product);
    }

//    THIS IS FUNCTION TO UPDATE A VALUE
    public void updateProduct(Product prod) {
        repo.save(prod);
    }


    public void deleteProduct(int prodID) {
        repo.deleteById(prodID);
    }
}
