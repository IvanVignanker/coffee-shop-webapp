package com.coffeeshop.model.entity.order.orderItem;

import com.coffeeshop.model.entity.base.BaseDate;
import com.coffeeshop.model.entity.order.order.OrderEntity;
import com.coffeeshop.model.entity.product.productItem.ProductItem;
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