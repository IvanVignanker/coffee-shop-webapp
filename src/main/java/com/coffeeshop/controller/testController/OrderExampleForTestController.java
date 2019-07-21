package com.coffeeshop.controller.testController;

import com.coffeeshop.model.entity.order.Order;
import com.coffeeshop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class OrderExampleForTestController {

    @Autowired
    OrderRepository orderRepository;

    @GetMapping("/orders/example")
    public List<Order> getAll(){
        return orderRepository.findAll();
    }

    @GetMapping("/orders/example/{id}")
    public Order getById(@PathVariable("id")Long id){
        return orderRepository
                .findById(id).orElseThrow(null);
    }

    @PostMapping("/orders/example")
    public Order saveOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }
}