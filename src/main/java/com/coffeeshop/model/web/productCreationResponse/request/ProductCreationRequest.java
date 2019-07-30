package com.coffeeshop.model.web.productCreationResponse.request;

import com.coffeeshop.model.entity.product.product.status.ProductType;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
public class ProductCreationRequest {

    private String shortDescription;
    private String description;
    private String previewImage;
    private Double unitPrice;
    private ProductType productCategoryId;
    private Boolean available;
    private Integer version;
}