package com.coffeeshop.model.customer.entity.order.order.converter;

import com.coffeeshop.model.customer.entity.order.order.status.OrderStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class OrderStatusConverter implements AttributeConverter<OrderStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(OrderStatus orderStatus) {
        return orderStatus == null ? OrderStatus.UNPROCESSED.getId() : orderStatus.getId();
    }

    @Override
    public OrderStatus convertToEntityAttribute(Integer integer) {
        return integer == null ? OrderStatus.UNPROCESSED : OrderStatus.getById(integer);
    }
}