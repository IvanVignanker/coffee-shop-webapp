package com.coffeeshop.model.customer.web.checkout;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class CheckoutProductsDTORequest {

    private Long productId;
    private Double weight;
    private Integer quantity;
}
