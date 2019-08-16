package com.coffeeshop.model.admin.response;

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
