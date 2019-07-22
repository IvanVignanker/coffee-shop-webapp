package com.coffeeshop.model.entity.product.product.converter;

import com.coffeeshop.model.entity.product.product.status.ProductType;

import javax.persistence.AttributeConverter;

public class ProductTypeConverter implements AttributeConverter<ProductType, Integer> {
    @Override
    public Integer convertToDatabaseColumn(ProductType productType) {
        return productType == null ? ProductType.COFFEE.getId() : productType.getId();
    }

    @Override
    public ProductType convertToEntityAttribute(Integer integer) {
        return integer == null ? ProductType.COFFEE : ProductType.getById(integer);
    }
}
