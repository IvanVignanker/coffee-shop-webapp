package com.coffeeshop.controller;

import com.coffeeshop.model.customer.entity.order.order.OrderEntity;
import com.coffeeshop.model.customer.entity.order.orderDetails.OrderDetails;
import com.coffeeshop.model.customer.entity.order.orderItem.OrderItem;
import com.coffeeshop.model.customer.entity.order.orderPrice.OrderPrice;
import com.coffeeshop.model.customer.entity.product.product.Product;
import com.coffeeshop.model.customer.entity.product.productCoffee.ProductCoffee;
import com.coffeeshop.model.customer.entity.product.productImage.ProductImage;
import com.coffeeshop.model.customer.entity.product.productItem.ProductItem;
import com.coffeeshop.model.customer.entity.product.productQuantity.ProductQuantity;
import com.coffeeshop.repository.order.OrderDetailsRepository;
import com.coffeeshop.repository.order.OrderItemRepository;
import com.coffeeshop.repository.order.OrderPriceRepository;
import com.coffeeshop.repository.order.OrderRepository;
import com.coffeeshop.repository.product.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StraightToRepositoriesTestController {

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @Autowired
    private OrderPriceRepository orderPriceRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductCoffeeRepository productCoffeeRepository;

    @Autowired
    private ProductImageRepository productImageRepository;

    @Autowired
    private ProductItemRepository productItemRepository;

    @Autowired
    private ProductQuantityRepository productQuantityRepository;

    @GetMapping("/productQuantity/example")
    public List<ProductQuantity> getAllProductQuantities(){
        return productQuantityRepository.findAll();
    }

    @GetMapping("/productQuantity/example/{id}")
    public ProductQuantity getByIdProductQuantity(@PathVariable("id")Long id){
        return productQuantityRepository
                .findById(id).orElseThrow(null);
    }

    @PostMapping("/productQuantity/example")
    public ProductQuantity saveProductQuantity(@RequestBody ProductQuantity productQuantity) {
        return productQuantityRepository.save(productQuantity);
    }

    @GetMapping("/productItem/example")
    public List<ProductItem> getAllProductItems(){
        return productItemRepository.findAll();
    }

    @GetMapping("/productItem/example/{id}")
    public ProductItem getByIdProductItem(@PathVariable("id")Long id){
        return productItemRepository
                .findById(id).orElseThrow(null);
    }

    @PostMapping("/productItem/example")
    public ProductItem saveProductItem(@RequestBody ProductItem productItem) {
        return productItemRepository.save(productItem);
    }

    @GetMapping("/productImage/example")
    public List<ProductImage> getAllProductImages(){
        return productImageRepository.findAll();
    }

    @GetMapping("/productImage/example/{id}")
    public ProductImage getByIdProductImage(@PathVariable("id")Long id){
        return productImageRepository
                .findById(id).orElseThrow(null);
    }

    @PostMapping("/productImage/example")
    public ProductImage saveProductImage(@RequestBody ProductImage productImage) {
        return productImageRepository.save(productImage);
    }

    @GetMapping("/productCoffee/example")
    public List<ProductCoffee> getAllProductCoffees(){
        return productCoffeeRepository.findAll();
    }

    @GetMapping("/productCoffee/example/{id}")
    public ProductCoffee getByIdProductCoffee(@PathVariable("id")Long id){
        return productCoffeeRepository
                .findById(id).orElseThrow(null);
    }

    @PostMapping("/productCoffee/example")
    public ProductCoffee saveProductCoffee(@RequestBody ProductCoffee productCoffee) {
        return productCoffeeRepository.save(productCoffee);
    }

    @GetMapping("/products/example")
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @GetMapping("/products/example/{id}")
    public Product getByIdProduct(@PathVariable("id")Long id){
        return productRepository
                .findById(id).orElseThrow(null);
    }

    @PostMapping("/products/example")
    public Product saveProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @GetMapping("/orders/example")
    public List<OrderEntity> getAllOrders(){
        return orderRepository.findAll();
    }

    @GetMapping("/orders/example/{id}")
    public OrderEntity getByIdOrder(@PathVariable("id")Long id){
        return orderRepository
                .findById(id).orElseThrow(null);
    }

    @PostMapping("/orders/example")
    public OrderEntity saveOrder(@RequestBody OrderEntity order) {
        return orderRepository.save(order);
    }

    @GetMapping("/orderItems/example")
    public List<OrderItem> getAllOrderItems(){
        return orderItemRepository.findAll();
    }

    @GetMapping("/orderItems/example/{id}")
    public OrderItem getByIdOrderItem(@PathVariable("id")Long id){
        return orderItemRepository
                .findById(id).orElseThrow(null);
    }

    @PostMapping("/orderItems/example")
    public OrderItem saveOrderItem(@RequestBody OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    @GetMapping("/orderPrice/example")
    public List<OrderPrice> getAllOrderPrices(){
        return orderPriceRepository.findAll();
    }

    @GetMapping("/orderPrice/example/{id}")
    public OrderPrice getByIdOrderPrice(@PathVariable("id")Long id){
        return orderPriceRepository
                .findById(id).orElseThrow(null);
    }

    @PostMapping("/orderPrice/example")
    public OrderPrice saveOrderPrice(@RequestBody OrderPrice orderPrice) {
        return orderPriceRepository.save(orderPrice);
    }

    @GetMapping("/orderDetails/example")
    public List<OrderDetails> getAllOrderDetails(){
        return orderDetailsRepository.findAll();
    }

    @GetMapping("/orderDetails/example/{id}")
    public OrderDetails getByIdOrderDetail(@PathVariable("id")Long id){
        return orderDetailsRepository
                .findById(id).orElseThrow(null);
    }

    @PostMapping("/orderDetails/example")
    public OrderDetails saveOrderDetail(@RequestBody OrderDetails orderDetails) {
        return orderDetailsRepository.save(orderDetails);
    }
}
