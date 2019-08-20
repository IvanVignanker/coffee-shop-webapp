package com.coffeeshop.repository.product;

import com.coffeeshop.model.customer.entity.product.productItem.ProductItem;
import com.coffeeshop.model.customer.entity.product.productItem.status.ProductStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {
    List<ProductItem> findAllByStatus(ProductStatus productStatus);
    Optional<List<ProductItem>> findAllByProductId(Long id);
}
