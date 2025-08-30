package com.handson.labs.graphql.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="author")
@Data
public class Author {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private int id;

    private String name;

    private String bio;
}
