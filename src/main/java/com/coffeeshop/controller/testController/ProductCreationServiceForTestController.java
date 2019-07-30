package com.coffeeshop.controller.testController;

import com.coffeeshop.model.web.productCreationResponse.request.ProductRequest;
import com.coffeeshop.model.web.productCreationResponse.response.ProductCreationResponse;
import com.coffeeshop.service.ProductCreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProductCreationServiceForTestController {

    @Autowired
    ProductCreationService productCreationService;

    @PostMapping("/createProduct")
    public ProductCreationResponse createProduct(
            @RequestBody ProductRequest productRequest) {
        return productCreationService.createProduct(productRequest);
    }

    //don't check. it's raw
    @PostMapping("/available/{id}")
    public void makeAvailable(
            @RequestParam(name = "id") Long id) {
        productCreationService.makeAvailable(id);
    }

    //also raw
    @PostMapping("/unAvailable/{id}")
    public void makeUnavailable(
            @RequestParam(name = "id") Long id) {
        productCreationService.makeUnavailable(id);
    }
}