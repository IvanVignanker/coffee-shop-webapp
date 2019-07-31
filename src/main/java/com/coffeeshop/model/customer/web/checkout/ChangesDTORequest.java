package com.coffeeshop.model.customer.web.checkout;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class ChangesDTORequest {

    private Integer shipping;
    private Double tax;
}
