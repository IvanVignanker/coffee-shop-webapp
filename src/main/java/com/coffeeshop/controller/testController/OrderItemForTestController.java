package com.coffeeshop.controller.testController;

import com.coffeeshop.model.entity.order.orderItem.OrderItem;
import com.coffeeshop.repository.order.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class OrderItemForTestController {

    @Autowired
    OrderItemRepository orderItemRepository;

    @GetMapping("/orderItems/example")
    public List<OrderItem> getAll(){
        return orderItemRepository.findAll();
    }

    @GetMapping("/orderItems/example/{id}")
    public OrderItem getById(@PathVariable("id")Long id){
        return orderItemRepository
                .findById(id).orElseThrow(null);
    }

    @PostMapping("/orderItems/example")
    public OrderItem saveOrderItems(@RequestBody OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }
}