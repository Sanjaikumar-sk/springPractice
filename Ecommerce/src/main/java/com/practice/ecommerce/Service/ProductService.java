package com.practice.ecommerce.Service;

import com.practice.ecommerce.Model.Product;
import com.practice.ecommerce.Repository.GetProductList;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    public Product addProduct(@NotNull Product product, @NotNull MultipartFile image) throws IOException {
        product.setImageName(image.getOriginalFilename());
        product.setImageType(image.getContentType());
        product.setImageData(image.getBytes());

        return repo.save(product);
    }

    public Product updateProduct(int id, MultipartFile image, Product product) throws IOException {

//        CHECK IF THERE IS A ROW WITH ID.
        Product product1 = repo.findById(id).orElse(null);

//        IF NOT RETURN NULL.
        if (product1 == null)
            return product1;

//        IF PRESENT SAVES THE UPDATED DATA AND RETURNS THE UPDATED PRODUCT.
        else
        {
            product.setImageData(image.getBytes());
            product.setImageName(image.getOriginalFilename());
            product.setImageType(image.getContentType());

            product1 = repo.save(product);
            return product1;
        }
    }

    public void deleteProduct(int id) {
        repo.deleteById(id);
    }

    public List<Product> searchProducts(String keyword) {
//        System.out.println("search parameter: (service)  "+keyword);
        return repo.searchProduct(keyword);
    }
}
