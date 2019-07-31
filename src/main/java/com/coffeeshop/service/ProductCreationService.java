package com.coffeeshop.service;

import com.coffeeshop.model.admin.web.productCreationResponse.request.ProductRequest;
import com.coffeeshop.model.admin.web.productCreationResponse.response.ProductCreationResponse;
import com.coffeeshop.model.admin.web.productCreationResponse.response.ProductMainCreationResponse;

public interface ProductCreationService {

    ProductCreationResponse createProduct(ProductRequest productRequest);
    ProductMainCreationResponse makeAvailable(Long id);
    ProductMainCreationResponse makeUnavailable(Long id);
}