package com.coffeeshop.model.web.productList;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class ProductListDTOResponse {
    PopularProductDTOResponse popularProductDTO;
    @Singular
    List<ProductDTOResponse> productDTOS;
}
