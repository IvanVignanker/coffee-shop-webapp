package com.coffeeshop.controller;

import com.coffeeshop.model.admin.response.ProductItemResponse;
import com.coffeeshop.repository.product.ProductItemRepository;
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

    @Autowired
    private ProductItemRepository productItemRepository;

    @PostMapping("/test/findAndMark")
    public List<ProductItemResponse> findAndMarkAsSold(@RequestBody Map<Long, Integer> items) {
        for(Map.Entry<Long, Integer> map: items.entrySet()) {
            System.out.println(map.getKey()+": "+map.getValue());
        }
        return productItemService.findAndMarkAsSold(items);
    }
}
