package com.coffeeshop.repository.order;

import com.coffeeshop.model.customer.entity.order.orderItem.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
