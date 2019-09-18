package com.coffeeshop.controller;

import com.coffeeshop.exception.InputValidationException;
import com.coffeeshop.model.admin.request.ProductItemRequest;
import com.coffeeshop.model.admin.request.ProductRequest;
import com.coffeeshop.model.admin.response.ProductCreationResponse;
import com.coffeeshop.model.admin.response.ProductMainCreationResponse;
import com.coffeeshop.model.customer.entity.product.productItem.ProductItem;
import com.coffeeshop.repository.product.ProductItemRepository;
import com.coffeeshop.service.admin.productCreation.ProductCreationService;
import com.coffeeshop.service.admin.productItem.ProductItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin/product")
@Profile("development")
public class ProductCreationManagementController {

    @Autowired
    private ProductCreationService productCreationService;

    @Autowired
    private ProductItemService productItemService;

    @Autowired
    private ProductItemRepository productItemRepository;

    @PostMapping("/addItems")
    public List<ProductItem> createProductItems(
            @RequestBody List<@Valid ProductItemRequest> productMainRequests, BindingResult result) {
        if (result.hasErrors()) {
            throw new InputValidationException(result);
        }
        productItemService.createProductItems(productMainRequests);

        return productItemRepository.findAll();
    }

    @PostMapping("/addProduct")
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
