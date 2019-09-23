package com.coffeeshop.controller;

import com.coffeeshop.model.admin.response.ProductItemResponse;
import com.coffeeshop.model.customer.entity.product.productItem.ProductItem;
import com.coffeeshop.repository.product.ProductItemRepository;
import com.coffeeshop.service.admin.productItem.ProductItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        return productItemService.findAndMarkAsSold(items);
    }

    @GetMapping("/findAndMark/{productId}/{amount}")
    public List<ProductItemResponse> findAndMarkAsSold(@PathVariable("productId") Long productId,
                                                       @PathVariable("amount") Integer amount) {
       Map<Long, Integer> map = new HashMap<>();
       map.put(productId, amount);
       return productItemService.findAndMarkAsSold(map);
    }

    @GetMapping("/getAllItems")
    public List<ProductItemResponse> getAllItems() {
        List<ProductItem> products = productItemRepository.findAll();
        return products.stream().map(x -> ProductItemResponse.builder()
                .productId(x.getProduct().getId())
                .id(x.getId())
                .status(x.getStatus())
                .build()).collect(Collectors.toList());
    }
}
