package com.jotacode.restfullapi.service;

import com.jotacode.restfullapi.data.entity.Order;
import com.jotacode.restfullapi.data.repository.OrderRepository;
import com.jotacode.restfullapi.error.OrderNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(Long id, Order order) throws OrderNotFoundException{
        if (orderRepository.findById(id).isPresent()){
            Order orderToUpdate = orderRepository.findById(id).get();
            orderToUpdate.setOrderId(order.getOrderId());
            orderToUpdate.setDescription(order.getDescription());
            orderToUpdate.setPrice(order.getPrice());
            return orderRepository.save(orderToUpdate);
        } else {
            throw new OrderNotFoundException("Order not found");
        }
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Order findById(Long id) throws OrderNotFoundException {
        if (orderRepository.findById(id).isPresent()){
            return orderRepository.findById(id).get();
        } else {
            throw new OrderNotFoundException("Order not found");
        }
    }
}
