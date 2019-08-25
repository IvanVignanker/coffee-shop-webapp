package com.coffeeshop.converter.productCreationConverter.admin.request;

import com.coffeeshop.model.admin.request.ProductCreationRequest;
import com.coffeeshop.model.customer.entity.product.product.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductRequestConverter {

    public Product converterToEntity(ProductCreationRequest productCreationRequest) {
        return Product.builder()
                .productName(productCreationRequest.getProductName())
                .shortDescription(productCreationRequest.getShortDescription())
                .description(productCreationRequest.getDescription())
                .previewImage(productCreationRequest.getPreviewImage())
                .unitPrice(productCreationRequest.getUnitPrice())
                .productCategoryId(productCreationRequest.getProductCategoryId())
                .build();
    }
}
