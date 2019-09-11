package com.coffeeshop.controller;

import com.coffeeshop.model.customer.web.productList.ProductListDTORequest;
import com.coffeeshop.repository.ProductSearchRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Query;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductSearchController {

    @Autowired
    private ProductSearchRepositoryCustom productSearchRepository;

    @PostMapping("/search")
    public List<Query> searchProductsByName(@RequestBody ProductListDTORequest productListDTORequest,
                                            BindingResult result) {
        return productSearchRepository.searchProductByName(productListDTORequest, result);
    }
}
