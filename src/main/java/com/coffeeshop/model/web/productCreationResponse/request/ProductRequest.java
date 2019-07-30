package com.coffeeshop.model.web.productCreationResponse.request;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductRequest {

    ProductCreationRequest productCreationRequest;
    ProductCoffeeCreation productCoffeeCreation;
    ProductItemCreation productItemCreation;
    ProductImageCreation productImageCreation;
    ProductQuantityCreation productQuantityCreation;
}