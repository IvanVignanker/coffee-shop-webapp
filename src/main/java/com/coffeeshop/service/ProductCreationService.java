package com.coffeeshop.service;

import com.coffeeshop.model.web.productCreationResponse.request.ProductRequest;
import com.coffeeshop.model.web.productCreationResponse.response.ProductCreationResponse;

public interface ProductCreationService {

    ProductCreationResponse createProduct(ProductRequest productRequest);
    void makeAvailable(Long id);
    void makeUnavailable(Long id);
}