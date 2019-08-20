package com.coffeeshop.service.admin.productItem;

import com.coffeeshop.exception.ProductNotFoundException;
import com.coffeeshop.model.admin.request.ProductItemRequest;
import com.coffeeshop.model.customer.entity.product.productItem.ProductItem;

import java.util.List;

public interface ProductItemService {
    void createProductItems(List<ProductItemRequest> productMainRequests);
    void createProductItem(ProductItemRequest productMainRequest) throws ProductNotFoundException;
    List<ProductItem> findAndMarkAsSold(Integer amount);
}
