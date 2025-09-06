package com.handson.labs.graphql.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "review")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Review {

    @Id
    private int id;

    private int rating;

    @Column(name = "comments")
    private String comment;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "book_id")
    private int bookId;
    
}
