package com.coffeeshop.repository.product;

import com.coffeeshop.model.customer.entity.product.productCoffee.ProductCoffee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductCoffeeRepository extends JpaRepository<ProductCoffee, Long> {
    Optional<ProductCoffee> findAllByProductId(Long id);
}
