package com.practice.ecommerce.Controller;

import com.practice.ecommerce.Model.Product;
import com.practice.ecommerce.Service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestPart("imageFile") MultipartFile imageFile, @RequestPart Product product )
    {
        System.out.println(product);
        try
        {
            Product product1 = service.addProduct(product, imageFile);
            return new ResponseEntity<>(product1, HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR );
        }
    }


}