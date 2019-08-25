package com.coffeeshop.model.customer.web.checkout;

import lombok.*;

import javax.validation.Valid;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class CheckoutSubmitDTORequest {

    @Valid
    CustomerInfoDTORequest customerInfo;

    @Singular
    List<CheckoutProductsDTORequest> products;
}
