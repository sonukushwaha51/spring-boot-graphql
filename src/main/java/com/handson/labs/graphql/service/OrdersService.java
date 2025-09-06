package com.handson.labs.graphql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.handson.labs.graphql.entity.Orders;
import com.handson.labs.graphql.repository.OrdersRepository;

@Service
public class OrdersService {

    @Autowired
    OrdersRepository ordersRepository;

    public List<Orders> getAllOrders() {
        return (List<Orders>) ordersRepository.findAll();
    }

    public Orders getOrderById(Integer id) {
        return ordersRepository.findById(id).orElse(null);
    }

    public void saveOrder(Orders order) {
        ordersRepository.save(order);
    }

    public void deleteOrderById(Integer id) {
        ordersRepository.deleteById(id);
    }



}
