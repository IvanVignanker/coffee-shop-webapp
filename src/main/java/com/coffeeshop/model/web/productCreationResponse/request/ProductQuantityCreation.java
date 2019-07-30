package com.coffeeshop.model.web.productCreationResponse.request;

import com.coffeeshop.model.entity.product.product.Product;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductQuantityCreation {

    Product product;

    private Integer quantity;
}
