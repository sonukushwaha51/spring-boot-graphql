package com.handson.labs.graphql.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="publisher")
@Data
public class Publisher {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private int id;

    private String name;

    private String country;
}
