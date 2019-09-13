package com.coffeeshop.controller;

import com.coffeeshop.exception.InputValidationException;
import com.coffeeshop.model.customer.web.productList.ProductListDTORequest;
import com.coffeeshop.model.customer.web.productList.ProductListDTOResponse;
import com.coffeeshop.repository.ProductSearchRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class ProductSearchController {

    @Autowired
    private ProductSearchRepositoryCustom productSearchRepository;

    @PostMapping("/search")
    public ProductListDTOResponse searchProductsByName(@RequestBody @Valid ProductListDTORequest productListDTORequest,
                                                       BindingResult result) {
        if (result.hasErrors()) {
            throw new InputValidationException(result);
        }
        return productSearchRepository.searchProductByName(productListDTORequest);
    }
}
