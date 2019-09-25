package com.coffeeshop.repository.custom;

import com.coffeeshop.model.customer.entity.product.product.Product;
import com.coffeeshop.model.customer.entity.product.productItem.ProductItem;
import com.coffeeshop.model.customer.entity.product.productItem.status.ProductStatus;

import java.util.List;

public interface ProductItemWithLimitsCustomRepository {
    List<ProductItem> findAllByProductIdAndStatusOrderByLimit(Product product, ProductStatus productStatus, int limit);
}
