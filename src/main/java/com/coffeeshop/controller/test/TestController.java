package com.coffeeshop.controller.test;

import com.coffeeshop.model.admin.response.ProductItemResponse;
import com.coffeeshop.repository.product.ProductItemRepository;
import com.coffeeshop.service.admin.productItem.ProductItemService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin/product")
public class TestController {

    @Autowired
    private ProductItemService productItemService;

    @Autowired
    private ProductItemRepository productItemRepository;

    @GetMapping("/findAndMark/{productId}/{amount}")
    public List<ProductItemResponse> findAndMarkAsSold(@PathVariable("productId") Long productId,
                                                       @PathVariable("amount") Integer amount) {
        Map<Long, Integer> map = new HashMap<>();
        map.put(productId, amount);
        return productItemService.findAndMarkAsSold(map);
    }

    @GetMapping("/findAndMark/{productId}/{amount}/{productId2}/{amount2}")
    public List<ProductItemResponse> findAndMarkAsSold(@PathVariable("productId") Long productId,
                                                       @PathVariable("amount") Integer amount,
                                                       @PathVariable("productId2") Long productId2,
                                                       @PathVariable("amount2") Integer amount2) {
        Map<Long, Integer> map = new HashMap<>();
        map.put(productId, amount);
        map.put(productId2, amount2);
        return productItemService.findAndMarkAsSold(map);
    }

    @PostMapping("/findAndMark")
    public List<ProductItemResponse> findAndMarkAsSold(@RequestBody Map<Long, Integer> items) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(gson.toJson(items));
        return productItemService.findAndMarkAsSold(items);
    }
}
