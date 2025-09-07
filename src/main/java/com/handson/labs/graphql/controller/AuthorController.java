package com.handson.labs.graphql.controller;

import com.handson.labs.graphql.entity.Author;
import com.handson.labs.graphql.entity.Book;
import com.handson.labs.graphql.entity.upsert.model.AuthorUpdate;
import com.handson.labs.graphql.entity.upsert.model.UpdateResponse;
import com.handson.labs.graphql.service.AuthorService;
import com.handson.labs.graphql.service.BookService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.BatchMapping;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.http.HttpStatus;
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
    BookService bookService;

    @SchemaMapping(typeName = "Library", field = "authors")
    public List<Author> authors(@Argument List<Integer> ids) {
        return authorService.getfromCacheOrClientCall(ids);
    }

    @BatchMapping(typeName = "Author", field = "books")
    public Map<Author, List<Book>> booksByAuthors(List<Author> authors) {
        List<Integer> ids = authors.stream().map(Author::getId).toList();
        List<Book> books =  bookService.getResultByParentIds(ids, "authors");

        return authors.stream()
                .collect(Collectors.toMap(
                        author -> author,
                        author -> books.stream()
                                .filter(book -> book.getAuthorId() == author.getId())
                                .toList()
                ));
    }

    @QueryMapping
    public Author authorById(@Argument Integer id) {
        return authorService.getFromCacheOrClientCall(id);
    }

    @MutationMapping(name = "updateAuthors")
    public UpdateResponse updateAuthors(@Argument AuthorUpdate author, @Argument List<AuthorUpdate> authors) {
        try {
            if (author != null) {
                if (author.getBook() != null) {
                    try {
                        bookService.saveBook(bookService.buildBookEntity(author.getBook()));
                    } catch (Exception e) {
                        log.error("Error saving book for author: " + e.getMessage());
                    }
                }
                authorService.saveAuthor(authorService.buildAuthorEntity(author));
            }
            if (authors != null && !authors.isEmpty()) {
                for (AuthorUpdate a : authors) {
                    if (a.getBook() != null) {
                        try {
                            bookService.saveBook(bookService.buildBookEntity(a.getBook()));
                        } catch (Exception e) {
                            log.error("Error saving book for author: " + e.getMessage());
                        }
                    }
                    authorService.saveAuthor(authorService.buildAuthorEntity(a));
                }
            }

        } catch (Exception e) {
            return UpdateResponse.builder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .message(e.getMessage())
                    .build();
        }
        return UpdateResponse.builder()
                .status(HttpStatus.OK.value())
                .message("Authors updated successfully")
                .build();
    }

}
