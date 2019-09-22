package com.coffeeshop.controller;

import com.coffeeshop.model.admin.response.ProductItemResponse;
import com.coffeeshop.service.admin.productItem.ProductItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin/product")
@Profile("development")
public class TestController {

    @Autowired
    private ProductItemService productItemService;

    @PostMapping("/test/findAndMark")
    public List<ProductItemResponse> findAndMarkAsSold(@RequestBody Map<Long, Integer> items) {
        return productItemService.findAndMarkAsSold(items);
    }
}
