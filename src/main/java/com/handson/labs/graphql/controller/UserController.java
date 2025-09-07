package com.handson.labs.graphql.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.BatchMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.handson.labs.graphql.entity.Review;
import com.handson.labs.graphql.entity.User;
import com.handson.labs.graphql.service.ReviewService;
import com.handson.labs.graphql.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ReviewService reviewService;

    @SchemaMapping(typeName = "Library", field = "users")
    public List<User> users(@Argument List<Integer> ids) {
        return userService.getfromCacheOrClientCall(ids);
    }

    @BatchMapping(typeName = "User", field = "reviewsByUserIds")
    public Map<User, List<Review>> reviewsByUsers(List<User> users) {
        List<Integer> userIds = users.stream().map(User::getId).toList();
        List<Review> reviews = reviewService.getResultByParentIds(userIds, "users");

        return users.stream()
                .collect(Collectors.toMap(
                        user -> user,
                        user -> reviews.stream()
                                .filter(review -> review.getUserId() == user.getId())
                                .toList()
                ));
    }
    
}
