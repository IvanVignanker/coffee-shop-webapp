package com.coffeeshop.converter;

import com.coffeeshop.converter.productCreationConverter.admin.request.ProductCoffeeRequestConverter;
import com.coffeeshop.converter.productCreationConverter.admin.request.ProductRequestConverter;
import com.coffeeshop.converter.productCreationConverter.customer.ProductDetailsResponseConverter;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter @Component
public class CommonConverter {

    ProductCoffeeRequestConverter productCoffeeRequestConverter;
    ProductRequestConverter productRequestConverter;
    ProductDetailsResponseConverter productDetailsResponseConverter;

    @Autowired
    public CommonConverter(ProductRequestConverter productRequestConverter,
                           ProductCoffeeRequestConverter productCoffeeRequestConverter,
                           ProductDetailsResponseConverter productDetailsResponseConverter) {
        this.productRequestConverter=productRequestConverter;
        this.productCoffeeRequestConverter=productCoffeeRequestConverter;
        this.productDetailsResponseConverter=productDetailsResponseConverter;
    }
}
