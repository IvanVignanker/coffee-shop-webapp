package com.coffeeshop.model.entity.order.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum OrderPaymentStatus {

    NO_INFO(1),
    PAY_ON_DELIVERY(2),
    PAID_ON_DELIVERY(3),
    PAID_BY_CC(4);

    private Integer id;

    public Integer getId() {
        return id;
    }

    public static OrderPaymentStatus getById(Integer id) {
        if (id == null) {
            return OrderPaymentStatus.NO_INFO;
        }
        return Arrays.stream(values())
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElseThrow(null);
    }
}