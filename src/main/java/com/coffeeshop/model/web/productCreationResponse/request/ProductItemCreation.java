package com.coffeeshop.model.web.productCreationResponse.request;

import com.coffeeshop.model.entity.product.product.Product;
import com.coffeeshop.model.entity.product.productItem.status.ProductStatus;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductItemCreation {

    Product product;

    private Integer weightKG;
    private ProductStatus status;
}
