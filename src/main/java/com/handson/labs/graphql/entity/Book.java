package com.handson.labs.graphql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="book")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    private int id;

    private String title;

    private String isbn;

    @Column(name="published_year")
    private int publishedYear;

    @Column(name="author_id")
    private int authorId;

    @Column(name="publisher_id")
    private int publisherId;

}
