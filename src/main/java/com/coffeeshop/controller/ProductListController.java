package com.coffeeshop.controller;

import com.coffeeshop.model.web.productList.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api")
public class ProductListController {

    @PostMapping("products")
    public List<ProductListDTOResponse> getProductList(@RequestBody ProductListDTORequest productListDTORequest) {
        return Stream.of(
                ProductListDTOResponse.builder().popularProductDTO(
                        PopularProductDTOResponse.builder()
                                .productDTO(
                                        ProductDTOResponse.builder()
                                                .productId(147852L).title("Third").shortDescription("Some third description")
                                                .type("Coffee").previewImage("Base64").price(16.45).inStockCount(32)
                                                .productsParametersDTO(
                                                        ProductsParametersDTOResponse.builder()
                                                                .flavour("strong").rate(2).decaf(true).coffeeType("arabika").build()).build()).build()).productDTO(
                        ProductDTOResponse.builder()
                                .productId(12345L).title("First").shortDescription("Some first description")
                                .type("Coffee").previewImage("Base64").price(78.25).inStockCount(78).productsParametersDTO(
                                ProductsParametersDTOResponse.builder()
                                        .flavour("strong").rate(1).decaf(false).coffeeType("arabika").build()).build()).build()).collect(Collectors.toList());
    }
}
