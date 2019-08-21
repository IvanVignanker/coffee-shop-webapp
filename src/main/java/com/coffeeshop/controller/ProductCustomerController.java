package com.coffeeshop.controller;

import com.coffeeshop.model.customer.web.productDetails.ProductDetailsDTOResponse;
import com.coffeeshop.service.customer.ProductSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductCustomerController {

    @Autowired
    private ProductSearchService productSearchService;

    @GetMapping("/customer/products/{id}")
    public ProductDetailsDTOResponse findProductById(@PathVariable("id") Long id) {
        return productSearchService.findProductById(id);
    }

    @GetMapping("/customer/products")
    public List<ProductDetailsDTOResponse> searchByParameters() {
        return productSearchService.searchByParameters();
    }
}