package com.coffeeshop.controller.admin;

import com.coffeeshop.exception.InputValidationException;
import com.coffeeshop.model.admin.request.ProductRequest;
import com.coffeeshop.model.admin.response.ProductCreationResponse;
import com.coffeeshop.model.admin.response.ProductMainCreationResponse;
import com.coffeeshop.service.admin.productCreation.ProductCreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("/api/admin/product")
public class ProductCreationServiceForTestController {

    @Autowired
    ProductCreationService productCreationService;

    @PostMapping("/add")
    public ProductCreationResponse createProduct(
            @RequestBody @Valid ProductRequest productRequest, BindingResult result) throws IOException {
        if (result.hasErrors()) {
            throw new InputValidationException(result);
        }
        return productCreationService.createProduct(productRequest);
    }

    @PostMapping("/makeAvailable/{id}")
    public ProductMainCreationResponse makeAvailable(@PathVariable("id") Long id) {
        return productCreationService.makeAvailable(id);
    }

    @PostMapping("/makeUnavailable/{id}")
    public ProductMainCreationResponse makeUnavailable(@PathVariable("id") Long id) {
        return productCreationService.makeUnavailable(id);
    }
}
