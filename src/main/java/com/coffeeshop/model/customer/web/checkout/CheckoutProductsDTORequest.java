package com.coffeeshop.model.customer.web.checkout;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class CheckoutProductsDTORequest {

    @ApiModelProperty(example = "123123")
    private Long productId;
    private Double weight;
    @ApiModelProperty(example = "200")
    private Integer quantity;
}
