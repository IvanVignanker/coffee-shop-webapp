package com.coffeeshop.model.customer.web.productList;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class PopularProductDTOResponse {
    private Long productId;
    private String title;
    private String shortDescription;
    private String type;
    private String previewImage;
    private Double price;
    private Integer availableAmount;

    ProductsParametersDTOResponse productParameters;
}
