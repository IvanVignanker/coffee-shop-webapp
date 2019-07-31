package com.coffeeshop.controller;

import com.coffeeshop.model.customer.web.checkout.CheckoutSubmitDTORequest;
import com.coffeeshop.model.customer.web.checkout.CheckoutSubmitDTOResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class CheckoutSubmitController {

    @PostMapping("/customer/checkout")
    public CheckoutSubmitDTOResponse submitCheckout(@RequestBody @Valid CheckoutSubmitDTORequest request) {
        return CheckoutSubmitDTOResponse.builder().orderId(1L).build();
    }
}
