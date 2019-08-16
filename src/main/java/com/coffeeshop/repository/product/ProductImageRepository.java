package com.coffeeshop.repository.product;

import com.coffeeshop.model.customer.entity.product.productImage.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {
    Optional<List<ProductImage>> findAllByProductId(Long id);
}
