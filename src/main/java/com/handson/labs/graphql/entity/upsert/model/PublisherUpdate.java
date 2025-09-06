package com.handson.labs.graphql.entity.upsert.model;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PublisherUpdate {

    private int id;
    private String name;
    private String country;
    private List<BookUpdate> books;

}
