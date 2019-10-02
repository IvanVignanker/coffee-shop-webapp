package com.coffeeshop.controller.customer;

import com.coffeeshop.exception.InputValidationException;
import com.coffeeshop.model.customer.web.productDetails.ProductDetailsDTOResponse;
import com.coffeeshop.model.customer.web.productList.ProductListDTORequest;
import com.coffeeshop.model.customer.web.productList.ProductListDTOResponse;
import com.coffeeshop.repository.custom.customer.ProductSearchRepositoryCustom;
import com.coffeeshop.service.customer.ProductSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@PropertySource(value = "classpath:defaultRequestValues.properties")
public class ProductCustomerController {

    @Value(value = "${default.page.value}")
    private Integer defaultPageRequest;

    @Value(value = "${default.result.value}")
    private Integer defaultResultRequest;

    @Value(value = "${default.max.result.value}")
    private Integer defaultMaxResultRequest;

    @Autowired
    private ProductSearchService productSearchService;

    @Autowired
    private ProductSearchRepositoryCustom productSearchRepository;

    @PostMapping("/products")
    public ProductListDTOResponse searchProductsByName(@RequestBody @Valid ProductListDTORequest productListDTORequest,
                                                       BindingResult result) {
        if (result.hasErrors()) {
            throw new InputValidationException(result);
        }
        if (productListDTORequest.getPage() == 0 || productListDTORequest.getPage().equals(null)) {
            productListDTORequest.setPage(defaultPageRequest);
        }
        if (productListDTORequest.getResults().equals(null) || productListDTORequest.getResults() < 1) {
            productListDTORequest.setResults(defaultResultRequest);
        }
        if (productListDTORequest.getResults() > 20) {
            productListDTORequest.setResults(defaultMaxResultRequest);
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
