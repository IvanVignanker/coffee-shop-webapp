package com.coffeeshop.controller;

import com.coffeeshop.model.web.productDetails.InStockDTOResponse;
import com.coffeeshop.model.web.productDetails.ProductCharacteristicsDTOResponse;
import com.coffeeshop.model.web.productDetails.ProductDetailsDTOResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProductDetailsController {

    @GetMapping("/customer/products/{id}")
    public ProductDetailsDTOResponse getProductDetails(@PathVariable("id") Long id) {
        return ProductDetailsDTOResponse.builder().productId(98765L).productName("Arabica Plantation AAA")
                .quantityAvailableKg(300).image("http://customer-ui/products/1/image/1").image("http://customer-ui/products/1/image/2")
                .characteristicsDTO(
                        ProductCharacteristicsDTOResponse.builder().strong(2).sour(2).bitter(3).build())
                .description("Product description").inStockDTO(
                        InStockDTOResponse.builder().isAvailable(true).quantityAvailable(20).build())
                .unitPrice(100.00).build();
    }
}
