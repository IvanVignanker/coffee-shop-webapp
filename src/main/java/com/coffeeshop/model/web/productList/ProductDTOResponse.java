package com.coffeeshop.model.web.productList;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class ProductDTOResponse {

    private Long productId;
    private String title;
    private String shortDescription;
    private String type;
    private String previewImage;
    private Double price;
    private Integer inStockCount;

    ProductsParametersDTOResponse productsParametersDTO;
}
