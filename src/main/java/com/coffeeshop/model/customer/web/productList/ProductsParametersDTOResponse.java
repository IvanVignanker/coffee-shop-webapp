package com.coffeeshop.model.customer.web.productList;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class ProductsParametersDTOResponse {

    private Integer strong;
    private Integer bitter;
    private Integer sour;
    private Boolean decaf;
    private String coffeeType;
}
