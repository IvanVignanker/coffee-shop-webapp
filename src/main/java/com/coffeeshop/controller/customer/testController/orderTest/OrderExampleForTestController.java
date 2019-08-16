package com.coffeeshop.controller.customer.testController.orderTest;

import com.coffeeshop.model.customer.entity.order.order.OrderEntity;
import com.coffeeshop.repository.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class OrderExampleForTestController {

    @Autowired
    OrderRepository orderRepository;

    @GetMapping("/orders/example")
    public List<OrderEntity> getAll(){
        return orderRepository.findAll();
    }

    @GetMapping("/orders/example/{id}")
    public OrderEntity getById(@PathVariable("id")Long id){
        return orderRepository
                .findById(id).orElseThrow(null);
    }

    @PostMapping("/orders/example")
    public OrderEntity saveOrder(@RequestBody OrderEntity order) {
        return orderRepository.save(order);
    }
}
