package com.coffeeshop.model.web.productCreationResponse.response;

import com.coffeeshop.model.entity.product.productItem.status.ProductStatus;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductItemCreationResponse {

    private Long id;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
    private Integer weightKG;
    private ProductStatus status;
    private Integer version;
}
