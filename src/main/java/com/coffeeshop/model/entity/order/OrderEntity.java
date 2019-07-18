package com.coffeeshop.model.entity.order;

import com.coffeeshop.model.entity.base.BaseDate;
import com.coffeeshop.model.entity.order.converter.OrderPaymentStatusConverter;
import com.coffeeshop.model.entity.order.converter.OrderStatusConverter;
import com.coffeeshop.model.entity.order.converter.OrderTransitStatusConverter;
import com.coffeeshop.model.entity.order.status.OrderPaymentStatus;
import com.coffeeshop.model.entity.order.status.OrderStatus;
import com.coffeeshop.model.entity.order.status.OrderTransitStatus;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity @Table(name = "ORDERS")
public class OrderEntity extends BaseDate {

    @Column(name = "ORDER_TRANSIT_STATUS")
    @Convert(converter = OrderTransitStatusConverter.class)
    private OrderTransitStatus orderTransitStatus;

    @Column(name = "ORDER_PAYMENT_STATUS")
    @Convert(converter = OrderPaymentStatusConverter.class)
    private OrderPaymentStatus orderPaymentStatus;

    @Column(name = "ORDER_STATUS")
    @Convert(converter = OrderStatusConverter.class)
    private OrderStatus orderStatus;
}