package com.coffeeshop.model.entity.order.orderPrice;

import com.coffeeshop.model.entity.base.BaseDate;
import com.coffeeshop.model.entity.order.order.OrderEntity;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "ORDER_PRICE")
public class OrderPrice extends BaseDate {

    @OneToOne
    @JoinColumn(name = "ORDER_ID", referencedColumnName = "ID", nullable = false)
    private OrderEntity orderId;

    @Column(name = "SUBTOTAL_PRICE")
    private String subtotalPrice;

    @Column(name = "SHIPPING_PRICE")
    private Double shippingPrice = 0.0;

    @Column(name = "DISCOUNT")
    private Double discount;
}