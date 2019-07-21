package com.coffeeshop.model.entity.product.productItem.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum ProductStatus {

    AVAILABLE(1),
    SOLD(2);

    private Integer id;

    public Integer getId() {
        return id;
    }

    public static ProductStatus getById(Integer id) {
        if (id == null) {
            return ProductStatus.AVAILABLE;
        }
        return Arrays.stream(values())
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .get();
    }
}