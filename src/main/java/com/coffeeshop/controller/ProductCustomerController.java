package com.coffeeshop.controller;

import com.coffeeshop.exception.InputValidationException;
import com.coffeeshop.model.customer.web.productDetails.ProductDetailsDTOResponse;
import com.coffeeshop.model.customer.web.productList.ProductListDTORequest;
import com.coffeeshop.model.customer.web.productList.ProductListDTOResponse;
import com.coffeeshop.repository.custom.ProductSearchRepositoryCustom;
import com.coffeeshop.service.customer.ProductSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductCustomerController {

    @Autowired
    private ProductSearchService productSearchService;

    @Autowired
    private ProductSearchRepositoryCustom productSearchRepository;

    @PostMapping("/products")
    public ProductListDTOResponse searchProductsByName(
            @RequestBody @Valid ProductListDTORequest productListDTORequest,
                                                       BindingResult result) {
        if (result.hasErrors()) {
            throw new InputValidationException(result);
        }
        return productSearchRepository.searchProductByName(productListDTORequest);
    }

    @GetMapping("/customer/products/{id}")
    public ProductDetailsDTOResponse findProductById(@PathVariable("id") Long id) {
        return productSearchService.findProductById(id);
    }

    @GetMapping("/customer/products")
    public List<ProductDetailsDTOResponse> searchByParameters() {
        return productSearchService.searchByParameters();
    }
}
