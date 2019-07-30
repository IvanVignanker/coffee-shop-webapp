package com.coffeeshop.service.converters;

import com.coffeeshop.model.entity.product.product.Product;
import com.coffeeshop.model.entity.product.productCoffee.ProductCoffee;
import com.coffeeshop.model.entity.product.productImage.ProductImage;
import com.coffeeshop.model.entity.product.productItem.ProductItem;
import com.coffeeshop.model.entity.product.productQuantity.ProductQuantity;
import com.coffeeshop.model.web.productCreationResponse.response.*;
import org.springframework.stereotype.Component;

@Component
public class ProductResponseConverter {

    public ProductCreationResponse converterToWeb(Product product,
                                                  ProductCoffee productCoffee,
                                                  ProductItem productItem,
                                                  ProductImage productImage,
                                                  ProductQuantity productQuantity) {
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
                .productItemCreationResponse(ProductItemCreationResponse.builder()
                        .id(productItem.getId())
                        .createdOn(productItem.getCreatedOn())
                        .updatedOn(productItem.getUpdatedOn())
                        .weightKG(productItem.getWeightKG())
                        .status(productItem.getStatus())
                        .version(productItem.getVersion())
                        .build())
                .productImageCreationResponse(ProductImageCreationResponse.builder()
                        .id(productImage.getId())
                        .createdOn(productImage.getCreatedOn())
                        .updatedOn(productImage.getUpdatedOn())
                        .image(productImage.getImage())
                        .build())
                .productQuantityCreationResponse(ProductQuantityCreationResponse.builder()
                        .id(productQuantity.getId())
                        .createdOn(productQuantity.getCreatedOn())
                        .updatedOn(productQuantity.getUpdatedOn())
                        .quantity(productQuantity.getQuantity())
                        .version(productQuantity.getVersion())
                        .build())
                .build();
    }
}