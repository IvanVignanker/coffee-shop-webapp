package com.coffeeshop.model.customer.entity.order.order;

import com.coffeeshop.model.customer.entity.base.BaseDate;
import com.coffeeshop.model.customer.entity.order.order.converter.OrderPaymentStatusConverter;
import com.coffeeshop.model.customer.entity.order.order.converter.OrderStatusConverter;
import com.coffeeshop.model.customer.entity.order.order.converter.OrderTransitStatusConverter;
import com.coffeeshop.model.customer.entity.order.order.status.OrderPaymentStatus;
import com.coffeeshop.model.customer.entity.order.order.status.OrderStatus;
import com.coffeeshop.model.customer.entity.order.order.status.OrderTransitStatus;
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