package com.coffeeshop.model.entity.order.order.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum OrderStatus {

    UNPROCESSED(1),
    IN_PROGRESS(2),
    CLOSED(3),
    ESCALATED(4);

    private Integer id;

    public Integer getId() {
        return id;
    }

    public static OrderStatus getById(Integer id) {
        if (id == null) {
            return OrderStatus.UNPROCESSED;
        }
        return Arrays.stream(values())
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .get();
    }
}