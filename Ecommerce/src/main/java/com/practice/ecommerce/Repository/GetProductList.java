package com.practice.ecommerce.Repository;

import com.practice.ecommerce.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GetProductList extends JpaRepository<Product, Integer> {
}
