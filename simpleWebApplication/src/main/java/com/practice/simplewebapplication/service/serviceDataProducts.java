package com.practice.simplewebapplication.service;

import com.practice.simplewebapplication.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class serviceDataProducts {

    List<Product> Products= new ArrayList<>( Arrays.asList(new Product(101,"Iphone", 100)));
//    TO GET ALL THE PRODUCTS
    public List<Product> getProducts()
    {
        return Products;
    }

//TO GET A PRODUCT BASED ON PRODUCT ID
    public Product getProductbyID( int prodID)
    {
        return Products.stream()
                .filter(p -> p.getProductID() == prodID)
                .findFirst().orElse(new Product(404, "Not found", 0));
    }

//TO ADD A NEW VALUE
    public void addProduct(Product product)
    {
        System.out.println(product);
        Products.add(product);
    }

//    THIS IS FUNCTION TO UPDATE A VALUE
    public void updateProduct(Product prod) {
        int i = 0;

        for(i = 0; i< Products.size(); i++)
        {
            if (Products.get(i).getProductID() == prod.getProductID())
                break;
        }
        Products.set(i, prod);
    }


    public void deleteProduct(int prodID) {
        int i = 0;

        for(i = 0; i< Products.size(); i++)
        {
            if (Products.get(i).getProductID() == prodID)
                break;
        }
        Products.remove(i);
    }
}
