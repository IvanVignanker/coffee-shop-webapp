package com.coffeeshop.model.customer.web.productList;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class ProductListDTOResponse {
    PopularProductDTOResponse popular;
    @Singular
    List<ProductDTOResponse> products;
}
