package com.practice.ecommerce.Service;

import com.practice.ecommerce.Model.Product;
import com.practice.ecommerce.Repository.GetProductList;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private GetProductList repo;

    //    CONSTRUCTOR INJECTION
    public ProductService(GetProductList repo)
    {
        this.repo = repo;
    }

    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public Product getProductByID(int id) {
        return repo.findById(id).orElse(null);
    }

//    public String addProduct( Product newProduct) {
//        repo.save(newProduct);
//        return "Product Added";
//    }
}
