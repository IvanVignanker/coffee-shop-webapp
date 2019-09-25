package com.coffeeshop.controller.test;

import com.coffeeshop.model.customer.web.checkout.CheckoutSubmitDTORequest;
import com.coffeeshop.model.customer.web.checkout.CheckoutSubmitDTOResponse;
import com.coffeeshop.model.customer.web.productList.*;
import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api")
public class MocksController {

    @GetMapping(value = "/customer/products/{productId}/images/{imageId}",
            produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] getImageWithMediaType(@PathVariable("productId") Long productId,
                                                      @PathVariable("imageId") String imageId)  throws IOException {
        final InputStream in = getClass()
                .getResourceAsStream("/images/black-coffee-bean-seed-shape-600w-1273417555.jpg");
        return IOUtils.toByteArray(in);
    }

    @PostMapping("/customer/checkout")
    public CheckoutSubmitDTOResponse submitCheckout(@RequestBody @Valid CheckoutSubmitDTORequest request) {
        return CheckoutSubmitDTOResponse.builder().orderId(1L).build();
    }
}
