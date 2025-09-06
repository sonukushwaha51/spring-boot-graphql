package com.handson.labs.graphql.entity.upsert.model;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthorUpdate {
    private int id;
    private String name;
    private String bio;
    private BookUpdate book;
    private List<BookUpdate> books;
}
