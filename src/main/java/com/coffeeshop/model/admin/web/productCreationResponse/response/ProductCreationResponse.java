package com.coffeeshop.model.admin.web.productCreationResponse.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductCreationResponse {

    ProductMainCreationResponse productMainCreationResponse;
    ProductCoffeeCreationResponse productCoffeeCreationResponse;
}
