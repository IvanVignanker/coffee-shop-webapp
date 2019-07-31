package com.coffeeshop.converter.productCreationConverter.response;

import com.coffeeshop.model.customer.entity.product.product.Product;
import com.coffeeshop.model.customer.entity.product.productCoffee.ProductCoffee;
import com.coffeeshop.model.admin.web.productCreationResponse.response.*;
import org.springframework.stereotype.Component;

@Component
public class ProductResponseConverter {

    public ProductCreationResponse converterToWeb(Product product,
                                                  ProductCoffee productCoffee) {
        return ProductCreationResponse.builder()
                .productMainCreationResponse(ProductMainCreationResponse.builder()
                        .id(product.getId())
                        .createdOn(product.getCreatedOn())
                        .updatedOn(product.getUpdatedOn())
                        .shortDescription(product.getShortDescription())
                        .description(product.getDescription())
                        .previewImage(product.getPreviewImage())
                        .unitPrice(product.getUnitPrice())
                        .productCategoryId(product.getProductCategoryId())
                        .available(product.getAvailable())
                        .version(product.getVersion())
                        .build())
                .productCoffeeCreationResponse(ProductCoffeeCreationResponse.builder()
                        .id(productCoffee.getId())
                        .createdOn(productCoffee.getCreatedOn())
                        .updatedOn(productCoffee.getUpdatedOn())
                        .sour(productCoffee.getSour())
                        .bitter(productCoffee.getBitter())
                        .strong(productCoffee.getStrong())
                        .ground(productCoffee.getGround())
                        .decaf(productCoffee.getDecaf())
                        .build())
                .build();
    }

    public ProductMainCreationResponse converterJustProductToWeb(Product product) {
        return ProductMainCreationResponse.builder()
                        .id(product.getId())
                        .createdOn(product.getCreatedOn())
                        .updatedOn(product.getUpdatedOn())
                        .shortDescription(product.getShortDescription())
                        .description(product.getDescription())
                        .previewImage(product.getPreviewImage())
                        .unitPrice(product.getUnitPrice())
                        .productCategoryId(product.getProductCategoryId())
                        .available(product.getAvailable())
                        .version(product.getVersion())
                        .build();
    }
}