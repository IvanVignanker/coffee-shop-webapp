package com.coffeeshop.repository.order;

import com.coffeeshop.model.entity.order.orderPrice.OrderPrice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderPriceRepository extends JpaRepository<OrderPrice, Long> {
}
