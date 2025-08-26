package com.handson.labs.graphql.controller;

import com.handson.labs.graphql.entity.Book;
import com.handson.labs.graphql.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    @SchemaMapping(typeName = "Library", field = "books")
    public List<Book> books() {
        return bookService.getAllBooks();
    }
}
