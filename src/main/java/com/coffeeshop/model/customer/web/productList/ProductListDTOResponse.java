package com.coffeeshop.model.customer.web.productList;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class ProductListDTOResponse {
    ProductDTOResponse popular;
    @Singular
    List<ProductDTOResponse> products;
}
