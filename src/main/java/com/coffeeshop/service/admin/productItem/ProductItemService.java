package com.coffeeshop.service.admin.productItem;

import com.coffeeshop.exception.ProductNotFoundException;
import com.coffeeshop.model.admin.request.ProductItemRequest;
import com.coffeeshop.model.admin.response.ProductItemResponse;
import com.coffeeshop.model.customer.entity.product.product.Product;
import com.coffeeshop.model.customer.entity.product.productItem.ProductItem;

import java.util.List;
import java.util.Map;

public interface ProductItemService {
    void createProductItems(List<ProductItemRequest> productMainRequests);
    void createProductItem(ProductItemRequest productMainRequest) throws ProductNotFoundException;

    List<ProductItemResponse> findAndMarkAsSold(Map<Long, Integer> items);
    List<ProductItem> findAndMarkAsSold(Product product, Integer amount);
}
