package com.coffeeshop.model.customer.entity.order.orderItem;

import com.coffeeshop.model.customer.entity.base.BaseDate;
import com.coffeeshop.model.customer.entity.order.order.OrderEntity;
import com.coffeeshop.model.customer.entity.product.productItem.ProductItem;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "ORDER_ITEMS")
public class OrderItem extends BaseDate {

    @OneToOne
    @JoinColumn(name = "ORDER_ID", referencedColumnName = "ID", nullable = false)
    private OrderEntity orderId;

    @OneToOne
    @JoinColumn(name = "PRODUCT_ITEM_ID", referencedColumnName = "ID", nullable = false)
    private ProductItem productItemId;
}