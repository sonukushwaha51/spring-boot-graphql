package com.handson.labs.graphql.entity.upsert.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookUpdate {
    private int id;
    private String title;
    private String isbn;
    private int publishedYear;
    private AuthorUpdate author;
    private PublisherUpdate publisher;
}
