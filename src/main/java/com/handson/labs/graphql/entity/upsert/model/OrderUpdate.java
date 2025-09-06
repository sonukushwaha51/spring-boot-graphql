package com.handson.labs.graphql.entity.upsert.model;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import com.handson.labs.graphql.entity.Book;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderUpdate {

    private int id;
    private int userId;
    private List<Book> books;

    @Builder.Default
    private Date orderDate = Date.from(Instant.now());

}