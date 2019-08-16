package com.coffeeshop.repository.product;

import com.coffeeshop.model.customer.entity.product.productQuantity.ProductQuantity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductQuantityRepository extends JpaRepository<ProductQuantity, Long> {
    Optional<ProductQuantity> findByProductId(Long id);
}
