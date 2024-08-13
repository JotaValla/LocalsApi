package com.jotacode.restfullapi.service;

import com.jotacode.restfullapi.data.entity.Order;
import com.jotacode.restfullapi.error.OrderNotFoundException;

import java.util.List;

public interface OrderService {

    List<Order> findAllOrders();

    Order saveOrder(Order order);

    Order updateOrder(Long id, Order order) throws OrderNotFoundException;

    void deleteOrder(Long id);

    Order findById(Long id) throws OrderNotFoundException;

}
