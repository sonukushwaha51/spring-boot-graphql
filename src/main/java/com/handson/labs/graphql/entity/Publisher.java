package com.handson.labs.graphql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="publisher")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Publisher {

    @Id
    private int id;

    private String name;

    private String country;
}
