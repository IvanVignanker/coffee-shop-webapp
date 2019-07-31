package com.coffeeshop.repository.product;

import com.coffeeshop.model.customer.entity.product.productCoffee.ProductCoffee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCoffeeRepository extends JpaRepository<ProductCoffee, Long> {
}