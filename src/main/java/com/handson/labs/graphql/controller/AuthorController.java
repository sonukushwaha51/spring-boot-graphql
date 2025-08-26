package com.handson.labs.graphql.controller;

import com.handson.labs.graphql.entity.Author;
import com.handson.labs.graphql.entity.Book;
import com.handson.labs.graphql.service.AuthorService;
import com.handson.labs.graphql.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.BatchMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@Slf4j
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    @SchemaMapping(typeName = "Library", field = "authors")
    public List<Author> authors(@Argument List<Integer> ids) {
        return authorService.getAllAuthors(ids);
    }

    @BatchMapping(typeName = "Author", field = "books")
    public Map<Author, List<Book>> booksByAuthors(List<Author> authors) {
        List<Integer> ids = authors.stream().map(Author::getId).toList();
        List<Book> books =  bookService.getAllBooksByAuthorIds(ids);

        return authors.stream()
                .collect(Collectors.toMap(
                        author -> author,
                        author -> books.stream()
                                .filter(book -> book.getAuthorId() == author.getId())
                                .toList()
                ));
    }

}
