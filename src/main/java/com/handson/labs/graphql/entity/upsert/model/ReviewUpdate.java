package com.handson.labs.graphql.entity.upsert.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReviewUpdate {
    private int id;
    private int rating;
    private String comment;
    private int userId;
    private int bookId;
}
