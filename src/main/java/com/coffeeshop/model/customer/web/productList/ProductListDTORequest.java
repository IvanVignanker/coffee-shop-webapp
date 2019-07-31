package com.coffeeshop.model.customer.web.productList;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter @Getter
@Builder
public class ProductListDTORequest {

    private Long page;
    private Integer results;
    private String search;
    private Double minPrice;
    private Double maxPrice;
    private String sortByDTORequestEnum;

    ProductCharacteristicsDTORequest productCharacteristicsDTORequest;
}
