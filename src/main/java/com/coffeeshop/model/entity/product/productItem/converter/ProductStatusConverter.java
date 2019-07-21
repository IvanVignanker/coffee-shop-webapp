package com.coffeeshop.model.entity.product.productItem.converter;

import com.coffeeshop.model.entity.product.productItem.status.ProductStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class ProductStatusConverter implements AttributeConverter<ProductStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(ProductStatus productStatus) {
        return productStatus == null ? ProductStatus.AVAILABLE.getId() : productStatus.getId();
    }

    @Override
    public ProductStatus convertToEntityAttribute(Integer integer) {
        return integer == null ? ProductStatus.AVAILABLE : ProductStatus.getById(integer);
    }
}