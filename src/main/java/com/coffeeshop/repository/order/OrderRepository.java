package com.coffeeshop.repository.order;

import com.coffeeshop.model.customer.entity.order.order.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}