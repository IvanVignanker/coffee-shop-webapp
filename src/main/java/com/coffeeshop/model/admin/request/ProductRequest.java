package com.coffeeshop.model.admin.request;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductRequest {

    @Valid
    @NotNull
    ProductCreationRequest productCreationRequest;

    @Valid
    @NotNull
    ProductCoffeeCreation productCoffeeCreation;
}
