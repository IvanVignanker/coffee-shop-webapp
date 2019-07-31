package com.coffeeshop.controller.testController.orderTest;

import com.coffeeshop.model.customer.entity.order.orderDetails.OrderDetails;
import com.coffeeshop.repository.order.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class OrderDetailsForTestController {

    @Autowired
    OrderDetailsRepository orderDetailsRepository;

    @GetMapping("/orderDetails/example")
    public List<OrderDetails> getAll(){
        return orderDetailsRepository.findAll();
    }

    @GetMapping("/orderDetails/example/{id}")
    public OrderDetails getById(@PathVariable("id")Long id){
        return orderDetailsRepository
                .findById(id).orElseThrow(null);
    }

    @PostMapping("/orderDetails/example")
    public OrderDetails saveOrderDetails(@RequestBody OrderDetails orderDetails) {
        return orderDetailsRepository.save(orderDetails);
    }
}