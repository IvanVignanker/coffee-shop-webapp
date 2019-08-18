package com.coffeeshop.repository.product;

import com.coffeeshop.model.customer.entity.product.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select ids.id from Product ids")
    List<Long> getAllIds();
}
