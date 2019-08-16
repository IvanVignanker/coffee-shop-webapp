package com.coffeeshop.model.admin.request;

import com.coffeeshop.model.customer.entity.product.product.Product;
import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductCoffeeCreation {

    Product product;

    @Min(value = 1)
    @Max(value = 5)
    @NotNull
    private Integer sour;

    @Min(value = 1)
    @Max(value = 5)
    @NotNull
    private Integer bitter;

    @Min(value = 1)
    @Max(value = 5)
    @NotNull
    private Integer strong;

    @NotNull
    private Boolean ground;

    @NotNull
    private Boolean decaf;
}
