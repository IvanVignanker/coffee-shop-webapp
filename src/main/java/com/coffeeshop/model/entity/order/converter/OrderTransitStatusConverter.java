package com.coffeeshop.model.entity.order.converter;

import com.coffeeshop.model.entity.order.status.OrderTransitStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class OrderTransitStatusConverter implements AttributeConverter<OrderTransitStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(OrderTransitStatus orderTransitStatus) {
        return orderTransitStatus == null ? OrderTransitStatus.NEW_ORDER.getId() : orderTransitStatus.getId();
    }

    @Override
    public OrderTransitStatus convertToEntityAttribute(Integer integer) {
        return integer == null ? OrderTransitStatus.NEW_ORDER : OrderTransitStatus.getById(integer);
    }
}