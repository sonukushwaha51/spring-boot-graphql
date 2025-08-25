package com.handson.labs.graphql.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="user")
@Data
public class User {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private int id;

    private String name;

    private String email;
}
