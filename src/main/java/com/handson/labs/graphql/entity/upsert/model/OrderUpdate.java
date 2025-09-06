package com.handson.labs.graphql.entity.upsert.model;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderUpdate {

    private int id;
    private int userId;
    private List<BookUpdate> books;

    @Builder.Default
    private Date orderDate = Date.from(Instant.now());

}