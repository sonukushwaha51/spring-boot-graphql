package com.handson.labs.graphql.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="category")
@Data
public class Category {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private int id;

    private String name;

    private String description;
}
