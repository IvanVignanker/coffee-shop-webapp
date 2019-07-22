package com.coffeeshop.controller.testController.orderTest;

import com.coffeeshop.model.entity.order.orderPrice.OrderPrice;
import com.coffeeshop.repository.order.OrderPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class OrderPriceForTestController {

    @Autowired
    OrderPriceRepository orderPriceRepository;

    @GetMapping("/orderPrice/example")
    public List<OrderPrice> getAll(){
        return orderPriceRepository.findAll();
    }

    @GetMapping("/orderPrice/example/{id}")
    public OrderPrice getById(@PathVariable("id")Long id){
        return orderPriceRepository
                .findById(id).orElseThrow(null);
    }

    @PostMapping("/orderPrice/example")
    public OrderPrice saveOrderItems(@RequestBody OrderPrice orderPrice) {
        return orderPriceRepository.save(orderPrice);
    }
}
