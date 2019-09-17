package com.coffeeshop.controller;

import com.coffeeshop.model.admin.response.ProductItemResponse;
import com.coffeeshop.model.customer.entity.product.productItem.ProductItem;
import com.coffeeshop.model.customer.entity.product.productItem.status.ProductStatus;
import com.coffeeshop.repository.product.ProductItemRepository;
import com.coffeeshop.service.admin.productItem.ProductItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

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
        for(Map.Entry<Long, Integer> map: items.entrySet()) {
            System.out.println(map.getKey()+": "+map.getValue());
        }
        return productItemService.findAndMarkAsSold(items);
    }

    @GetMapping("/sold/{status}")
    public void findAllSold(@PathVariable("status")ProductStatus productStatus) {
        List<ProductItem> items = productItemRepository.findAllByStatus(productStatus);
        for (ProductItem item: items) {
            System.out.println(item.getProduct().getId());
            System.out.println(items.size());
        }
    }
}
