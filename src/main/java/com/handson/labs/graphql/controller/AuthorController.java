package com.handson.labs.graphql.controller;

import com.handson.labs.graphql.entity.Author;
import com.handson.labs.graphql.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @SchemaMapping(typeName = "Library", field = "authors")
    private List<Author> authors(@Argument List<String> names) {
        return authorService.getAllAuthors();
    }
}
