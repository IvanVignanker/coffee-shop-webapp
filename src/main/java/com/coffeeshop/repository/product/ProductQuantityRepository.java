package com.coffeeshop.repository.product;

import com.coffeeshop.model.entity.product.productQuantity.ProductQuantity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductQuantityRepository extends JpaRepository<ProductQuantity, Long> {
}
