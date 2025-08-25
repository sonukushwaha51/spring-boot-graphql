package com.handson.labs.graphql.controller;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.execution.GraphQlSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValidateSchemaController {

    private final GraphQlSource graphQlSource;

    public ValidateSchemaController(GraphQlSource graphQlSource) {
        this.graphQlSource = graphQlSource;
    }

    @GetMapping("/schema")
    public String getSchema() {
        return graphQlSource.schema().getType("Book").toString();
    }

    @QueryMapping
    public String query() {
        return "Book schema is loaded!";
    }

}
