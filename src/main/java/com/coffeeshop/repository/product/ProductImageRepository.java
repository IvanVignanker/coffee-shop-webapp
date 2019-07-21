package com.coffeeshop.repository.product;

import com.coffeeshop.model.entity.product.productImage.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {
}
