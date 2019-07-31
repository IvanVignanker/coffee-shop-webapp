package com.coffeeshop.controller.testController.productTest;

import com.coffeeshop.model.customer.entity.product.productQuantity.ProductQuantity;
import com.coffeeshop.repository.product.ProductQuantityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class ProductQuantityForTestController {

    @Autowired
    ProductQuantityRepository productQuantityRepository;

    @GetMapping("/productQuantity/example")
    public List<ProductQuantity> getAll(){
        return productQuantityRepository.findAll();
    }

    @GetMapping("/productQuantity/example/{id}")
    public ProductQuantity getById(@PathVariable("id")Long id){
        return productQuantityRepository
                .findById(id).orElseThrow(null);
    }

    @PostMapping("/productQuantity/example")
    public ProductQuantity saveProductItem(@RequestBody ProductQuantity productQuantity) {
        return productQuantityRepository.save(productQuantity);
    }
}