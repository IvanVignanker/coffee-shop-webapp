package com.coffeeshop.controller.testController.productTest;

import com.coffeeshop.model.entity.product.productImage.ProductImage;
import com.coffeeshop.repository.product.ProductImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class ProductImageForTestController {

    @Autowired
    ProductImageRepository productImageRepository;

    @GetMapping("/productImage/example")
    public List<ProductImage> getAll(){
        return productImageRepository.findAll();
    }

    @GetMapping("/productImage/example/{id}")
    public ProductImage getById(@PathVariable("id")Long id){
        return productImageRepository
                .findById(id).orElseThrow(null);
    }

    @PostMapping("/productImage/example")
    public ProductImage saveProductItem(@RequestBody ProductImage productImage) {
        return productImageRepository.save(productImage);
    }
}