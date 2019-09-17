package com.coffeeshop.model.admin.response;

import com.coffeeshop.model.customer.entity.product.productItem.status.ProductStatus;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductItemResponse {

    private Long id;
    private Long productId;
    private Integer weightKG;
    private ProductStatus status;
}
