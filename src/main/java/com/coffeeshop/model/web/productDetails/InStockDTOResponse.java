package com.coffeeshop.model.web.productDetails;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class InStockDTOResponse {

    private Boolean isAvailable;
    private Integer quantityAvailable;
}
