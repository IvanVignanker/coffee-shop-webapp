package com.coffeeshop.controller.admin;

import com.coffeeshop.exception.InputValidationException;
import com.coffeeshop.model.admin.request.ProductItemRequest;
import com.coffeeshop.model.customer.entity.product.productItem.ProductItem;
import com.coffeeshop.service.admin.productItem.ProductItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/admin/productItem")
public class ProductItemCreationServiceForTestController {

    @Autowired
    ProductItemService productItemService;

    @PostMapping("/add")
    public void createProductItems(
            @RequestBody List<@Valid ProductItemRequest> productMainRequests, BindingResult result) {
        if (result.hasErrors()) {
            throw new InputValidationException(result);
        }
        productItemService.createProductItems(productMainRequests);
    }

    @PutMapping("/findAndMark/{amount}")
    public List<ProductItem> findAndMarkAsSold(@PathVariable("amount") Integer amount) {
        return productItemService.findAndMarkAsSold(amount);
    }
}
