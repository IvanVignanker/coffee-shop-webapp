package com.coffeeshop.service.productCreation;

import com.coffeeshop.model.admin.request.ProductRequest;
import com.coffeeshop.model.admin.response.ProductCreationResponse;
import com.coffeeshop.model.admin.response.ProductMainCreationResponse;

public interface ProductCreationService {

    ProductCreationResponse createProduct(ProductRequest productRequest);
    ProductMainCreationResponse makeAvailable(Long id);
    ProductMainCreationResponse makeUnavailable(Long id);
}
