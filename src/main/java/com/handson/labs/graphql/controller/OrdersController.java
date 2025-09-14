package com.handson.labs.graphql.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.BatchMapping;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.handson.labs.graphql.entity.Orders;
import com.handson.labs.graphql.entity.User;
import com.handson.labs.graphql.entity.upsert.model.BookUpdate;
import com.handson.labs.graphql.entity.upsert.model.OrderUpdate;
import com.handson.labs.graphql.service.BookService;
import com.handson.labs.graphql.service.OrdersService;
import com.handson.labs.graphql.service.UserService;

@Controller
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @SchemaMapping(typeName = "Library", field = "orders")
    public List<Orders> orders(@Argument List<Integer> ids) {
        return ordersService.getClientResults(ids);
    }

    @BatchMapping(typeName = "Order", field = "user")
    public Map<Orders, User> userByOrders(List<Orders> orders) {
        List<Integer> userIds = orders.stream().map(Orders::getUserId).toList();
        List<User> users = userService.getClientResults(userIds);

        return orders.stream()
                .collect(Collectors.toMap(
                        order -> order,
                        order -> users.stream()
                                .filter(user -> user.getId() == order.getUserId())
                                .findFirst()
                                .orElse(null)
                ));
    }

    @MutationMapping(name = "createOrder")
    public Orders createOrder(@Argument OrderUpdate order) {
        Orders newOrder = ordersService.buiOrders(order);
        for (BookUpdate book : order.getBooks()) {
            try {
                bookService.saveBook(bookService.buildBookEntity(book));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ordersService.saveOrder(newOrder);
        
    }

}
