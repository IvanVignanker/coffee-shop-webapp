package com.coffeeshop.model.web.productCreationResponse.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductCreationResponse {

    ProductMainCreationResponse productMainCreationResponse;
    ProductCoffeeCreationResponse productCoffeeCreationResponse;
    ProductItemCreationResponse productItemCreationResponse;
    ProductImageCreationResponse productImageCreationResponse;
    ProductQuantityCreationResponse productQuantityCreationResponse;
}
