package com.coffeeshop.repository.product;

import com.coffeeshop.model.entity.product.productItem.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {
}
