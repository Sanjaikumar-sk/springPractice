package com.practice.ecommerce.Controller;
import com.practice.ecommerce.Model.Product;
import com.practice.ecommerce.Service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    @GetMapping("/product/{productid}/image")
    public ResponseEntity<byte[]> getImageByProductID(@PathVariable int productid)
    {
        System.out.println(productid);
        Product product = service.getProductByID(productid);
        byte[] imageData = product.getImageData();

        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(product.getImageType()))
                .body(imageData);
    }

//    UPDATE A PRODUCT
    @PutMapping("/product/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestPart("imageFile") MultipartFile image, @RequestPart Product product) throws IOException {
        Product product1 = service.updateProduct(id, image, product);

//        IF NULL IS RETURNED, IT MEANS THERE ARE NO PRODUCT BY THE ID. ELSE IT IS STORED AND SENT.
        if (product1 != null)
            return new ResponseEntity<>("Updated", HttpStatus.OK);
        else
            return new ResponseEntity<>("Not Updated", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id)
    {
        if (service.getProductByID(id) == null)
            return new ResponseEntity<>("Product Not found", HttpStatus.BAD_REQUEST);
        else {
            service.deleteProduct(id);
            return new ResponseEntity<>("Product deleted", HttpStatus.OK);
        }
    }

    @GetMapping("/products/search")
    public ResponseEntity<List<Product>> searchProduct(@RequestParam String keyword)
    {
        List<Product> product1 = service.searchProducts(keyword);
        return new ResponseEntity<>( product1, HttpStatus.OK);
    }

//    @GetMapping("/getCSRFtoken")
//    public CsrfToken getCSRFtoken(HttpServletRequest request)
//    {
//        return (CsrfToken) request.getAttribute("_csrf");
//    }
}