package com.coffeeshop.model.web.productCreationResponse.request;

import com.coffeeshop.model.entity.product.product.Product;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductCoffeeCreation {

    Product product;

    private Integer sour;
    private Integer bitter;
    private Integer strong;
    private Boolean ground;
    private Boolean decaf;
}
