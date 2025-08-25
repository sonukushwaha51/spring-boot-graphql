package com.handson.labs.graphql.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="book")
@Data
public class Book {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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
