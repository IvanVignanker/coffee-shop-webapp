package com.coffeeshop.controller.customer.testController.productTest;

import com.coffeeshop.model.customer.entity.product.productItem.ProductItem;
import com.coffeeshop.repository.product.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class ProductItemForTestController {

    @Autowired
    ProductItemRepository productItemRepository;

    @GetMapping("/productItem/example")
    public List<ProductItem> getAll(){
        return productItemRepository.findAll();
    }

    @GetMapping("/productItem/example/{id}")
    public ProductItem getById(@PathVariable("id")Long id){
        return productItemRepository
                .findById(id).orElseThrow(null);
    }

    @PostMapping("/productItem/example")
    public ProductItem saveProductItem(@RequestBody ProductItem productItem) {
        return productItemRepository.save(productItem);
    }
}
