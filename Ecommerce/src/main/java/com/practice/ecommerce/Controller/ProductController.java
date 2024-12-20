package com.practice.ecommerce.Controller;

import com.practice.ecommerce.Model.Product;
import com.practice.ecommerce.Service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Provider;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {
    ProductService service;

    public ProductController( ProductService service )
    {
        this.service=service;
    }

    @GetMapping("/")
    public String greet()
    {
        return "Hellow world";
    }

    @GetMapping("/products")
    public List<Product> GetAllProducts()
    {
        return service.getAllProducts();
    }

    @PostMapping("/addProduct")
    public String addNewProduct( @RequestBody Product newProduct)
    {
        return service.addProduct(newProduct);
    }
}