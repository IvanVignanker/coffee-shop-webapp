package com.coffeeshop.converter;

import com.coffeeshop.converter.productCreationConverter.request.ProductCoffeeRequestConverter;
import com.coffeeshop.converter.productCreationConverter.request.ProductRequestConverter;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter @Component
public class CommonRequestConverter {

    ProductCoffeeRequestConverter productCoffeeRequestConverter;
    ProductRequestConverter productRequestConverter;

    @Autowired
    public CommonRequestConverter(ProductRequestConverter productRequestConverter,
                                  ProductCoffeeRequestConverter productCoffeeRequestConverter) {
        this.productRequestConverter=productRequestConverter;
        this.productCoffeeRequestConverter=productCoffeeRequestConverter;
    }
}