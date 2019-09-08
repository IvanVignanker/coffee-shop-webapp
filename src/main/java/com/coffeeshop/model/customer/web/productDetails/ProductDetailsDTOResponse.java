package com.coffeeshop.model.customer.web.productDetails;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class ProductDetailsDTOResponse {

    private Long productId;
    private String productName;
    private String description;
    private String shortDescription;

    @Singular
    private List<String> images;
    private String previewImage;

    ProductCharacteristicsDTOResponse characteristics;

    private Integer amountAvailable;
    private Double price;
}
