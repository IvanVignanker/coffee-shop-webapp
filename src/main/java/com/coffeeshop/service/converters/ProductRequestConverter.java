package com.coffeeshop.service.converters;

import com.coffeeshop.model.entity.product.product.Product;
import com.coffeeshop.model.entity.product.productCoffee.ProductCoffee;
import com.coffeeshop.model.entity.product.productImage.ProductImage;
import com.coffeeshop.model.entity.product.productItem.ProductItem;
import com.coffeeshop.model.entity.product.productQuantity.ProductQuantity;
import com.coffeeshop.model.web.productCreationResponse.request.*;
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

    public ProductCoffee converterToCoffeeEntity(
            ProductCoffeeCreation productCoffeeCreation, Product product) {
        return ProductCoffee.builder()
                .product(product)
                .sour(productCoffeeCreation.getSour())
                .bitter(productCoffeeCreation.getBitter())
                .strong(productCoffeeCreation.getStrong())
                .ground(productCoffeeCreation.getGround())
                .decaf(productCoffeeCreation.getDecaf())
                .build();
    }

    public ProductItem converterToItemEntity(
            ProductItemCreation productItemCreation, Product product) {
        return ProductItem.builder()
                .product(product)
                .weightKG(productItemCreation.getWeightKG())
                .status(productItemCreation.getStatus())
                .build();
    }

    public ProductImage converterToImageEntity(
            ProductImageCreation productImageCreation, Product product) {
        return ProductImage.builder()
                .product(product)
                .image(productImageCreation.getImage())
                .build();
    }

    public ProductQuantity converterToQuantityEntity(
            ProductQuantityCreation productQuantityCreation, Product product) {
        return ProductQuantity.builder()
                .product(product)
                .quantity(productQuantityCreation.getQuantity())
                .build();
    }
}