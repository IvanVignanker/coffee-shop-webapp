package com.coffeeshop.repository.custom;

import com.coffeeshop.model.customer.entity.product.product.Product;
import com.coffeeshop.model.customer.entity.product.productItem.ProductItem;
import com.coffeeshop.model.customer.entity.product.productItem.status.ProductStatus;

import java.util.List;

public interface ProductItemRepositoryCustom {
    List<ProductItem> findProductItemByProductAndProductStatusLimitIs(Product product,
                                                                      ProductStatus status,
                                                                      int limit);
}
