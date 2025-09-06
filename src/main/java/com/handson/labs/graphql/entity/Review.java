package com.handson.labs.graphql.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Table(name = "review")
@Builder
public class Review {

    @Id
    @GeneratedValue(strategy =  GenerationType.SEQUENCE)
    private int id;

    private int rating;
    private String comments;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "book_id")
    private int bookId;
    
}
