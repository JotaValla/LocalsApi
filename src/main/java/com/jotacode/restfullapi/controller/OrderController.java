package com.jotacode.restfullapi.controller;

import com.jotacode.restfullapi.data.entity.Order;
import com.jotacode.restfullapi.error.OrderNotFoundException;
import com.jotacode.restfullapi.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    //Get all orders
    @GetMapping("/orders")
    public List<Order> getAllOrders(){
        return orderService.findAllOrders();
    }

    //save order
    @PostMapping("/orders")
    public Order saveOrder(@Valid @RequestBody Order order){
        return orderService.saveOrder(order);
    }

    //Get order by id
    @GetMapping("/orders/{id}")
    public Order getOrderById(@PathVariable Long id) throws OrderNotFoundException {
        return orderService.findById(id);
    }

    //Update order
    @PutMapping("/orders/{id}")
    public Order updateOrder(@PathVariable Long id, @Valid @RequestBody Order order) throws OrderNotFoundException {
        return orderService.updateOrder(id, order);
    }

    //Delete order
    @DeleteMapping("/orders/{id}")
    public void deleteOrder(@PathVariable Long id) throws OrderNotFoundException {
        orderService.deleteOrder(id);
    }


}
