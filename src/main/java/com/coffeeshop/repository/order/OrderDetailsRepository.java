package com.coffeeshop.repository.order;

import com.coffeeshop.model.customer.entity.order.orderDetails.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {
}
