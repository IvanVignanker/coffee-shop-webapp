package com.coffeeshop.model.entity.order.order.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum OrderTransitStatus {

    NEW_ORDER(1),
    SHIPPED(2),
    DELIVERED(3),
    RETURNED(4);

    private Integer id;

    public Integer getId() {
        return id;
    }

    public static OrderTransitStatus getById(Integer id) {
        if (id == null) {
            return OrderTransitStatus.NEW_ORDER;
        }
        return Arrays.stream(values())
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .get();
    }
}