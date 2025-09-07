package com.handson.labs.graphql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.handson.labs.graphql.configuration.LibraryCache;
import com.handson.labs.graphql.entity.Orders;
import com.handson.labs.graphql.entity.upsert.model.OrderUpdate;
import com.handson.labs.graphql.repository.OrdersRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrdersService extends RedisCacheService<Orders> {

    public OrdersService(RedisTemplate<String, Object> redisTemplate) {
        super(redisTemplate, LibraryCache.ORDERS, Orders.class);
    }

    @Autowired
    OrdersRepository ordersRepository;

    public List<Orders> getAllOrders() {
        return (List<Orders>) ordersRepository.findAll();
    }

    public Orders getOrderById(Integer id) {
        return ordersRepository.findById(id).orElse(null);
    }

    public Orders saveOrder(Orders order) {
        return ordersRepository.save(order);
    }

    public void deleteOrderById(Integer id) {
        ordersRepository.deleteById(id);
    }

    public List<Orders> getAllOrdersByIds(List<Integer> ids) {
        return (List<Orders>) ordersRepository.findAllById(ids);
    }

    public Orders buiOrders(OrderUpdate orderUpdate) {
        return Orders.builder()
                .id(orderUpdate.getId())
                .userId(orderUpdate.getUserId())
                .build();
    }

    @Override
    protected List<Orders> getAllFromClient(List<Integer> ids) {
        log.info("Fetching orders from DB for Ids : {}", ids);
        return getAllOrdersByIds(ids);
    }

}
