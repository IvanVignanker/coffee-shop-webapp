package com.coffeeshop.controller.admin;

import com.coffeeshop.exception.InputValidationException;
import com.coffeeshop.model.admin.request.ProductItemRequest;
import com.coffeeshop.model.customer.entity.product.productItem.ProductItem;
import com.coffeeshop.repository.product.ProductItemRepository;
import com.coffeeshop.service.admin.productItem.ProductItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/admin/product")
@Profile("dev")
public class ProductItemCreationManagementController {


    @Autowired
    private ProductItemRepository productItemRepository;

    @Autowired
    private ProductItemService productItemService;

    @PostMapping("/addItems")
    public List<ProductItem> createProductItems(
            @RequestBody List<@Valid ProductItemRequest> productMainRequests, BindingResult result) {
        if (result.hasErrors()) {
            throw new InputValidationException(result);
        }
        productItemService.createProductItems(productMainRequests);

        return productItemRepository.findAll();
    }
}
