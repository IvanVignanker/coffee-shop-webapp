package com.coffeeshop.controller.testController.productTest;

import com.coffeeshop.model.customer.entity.product.productCoffee.ProductCoffee;
import com.coffeeshop.repository.product.ProductCoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class ProductCoffeeForTestController {

    @Autowired
    ProductCoffeeRepository productCoffeeRepository;

    @GetMapping("/productCoffee/example")
    public List<ProductCoffee> getAll(){
        return productCoffeeRepository.findAll();
    }

    @GetMapping("/productCoffee/example/{id}")
    public ProductCoffee getById(@PathVariable("id")Long id){
        return productCoffeeRepository
                .findById(id).orElseThrow(null);
    }

    @PostMapping("/productCoffee/example")
    public ProductCoffee saveProductCoffee(@RequestBody ProductCoffee productCoffee) {
        return productCoffeeRepository.save(productCoffee);
    }
}
