package com.practice.ecommerce.Controller;

import com.practice.ecommerce.Model.Product;
import com.practice.ecommerce.Service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public  List<Product> GetAllProducts()
    {
        return service.getAllProducts();
    }

    @GetMapping("/product/{ID}")
    public ResponseEntity<Product> getProductByID(@PathVariable int ID)
    {
        Product product = service.getProductByID(ID);
        if (product != null)
            return  new ResponseEntity<>(service.getProductByID(ID), HttpStatus.OK);

        else
            return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
    }



//    @PostMapping("/addProduct")
//    public String addNewProduct( @RequestBody Product newProduct)
//    {
//        return service.addProduct(newProduct);
//    }
}