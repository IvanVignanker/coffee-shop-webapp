package com.coffeeshop.model.customer.entity.product.product.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum ProductType {
    COFFEE(1);

    private Integer id;

    public Integer getId() {
        return id;
    }

    public static ProductType getById(Integer id) {
        if (id == null) {
            return ProductType.COFFEE;
        }
        return Arrays.stream(values())
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .get();
    }
}