package com.practice.ecommerce.Repository;

import com.practice.ecommerce.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GetProductList extends JpaRepository<Product, Integer> {

    @Query("SELECT p from Product p "+
    "WHERE lower(p.name) like lower(concat('%', :keyword , '%') ) OR " +
            "lower(p.brand) like lower(concat('%', :keyword, '%') ) or " +
            "lower(p.category) like lower(concat('%', :keyword, '%') ) or " +
            "lower(p.description) like lower(concat('%', :keyword , '%') )")
    List<Product> searchProduct(String keyword);
}
