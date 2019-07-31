package com.coffeeshop.converter.productCreationConverter.request;

import com.coffeeshop.model.admin.web.productCreationResponse.request.ProductCoffeeCreation;
import com.coffeeshop.model.customer.entity.product.product.Product;
import com.coffeeshop.model.customer.entity.product.productCoffee.ProductCoffee;
import org.springframework.stereotype.Component;

@Component
public class ProductCoffeeRequestConverter {

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
}