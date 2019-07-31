package com.coffeeshop.converter.productCreationConverter.request;

import com.coffeeshop.model.customer.entity.product.product.Product;
import com.coffeeshop.model.admin.web.productCreationResponse.request.*;
import org.springframework.stereotype.Component;

@Component
public class ProductRequestConverter {

    public Product converterToEntity(ProductCreationRequest productCreationRequest) {
        return Product.builder()
                .shortDescription(productCreationRequest.getShortDescription())
                .description(productCreationRequest.getDescription())
                .previewImage(productCreationRequest.getPreviewImage())
                .unitPrice(productCreationRequest.getUnitPrice())
                .productCategoryId(productCreationRequest.getProductCategoryId())
                .available(productCreationRequest.getAvailable())
                .version(productCreationRequest.getVersion())
                .build();
    }
}