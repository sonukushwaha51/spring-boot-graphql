package com.handson.labs.graphql.controller;

import com.handson.labs.graphql.entity.Book;
import com.handson.labs.graphql.entity.upsert.model.BookUpdate;
import com.handson.labs.graphql.entity.upsert.model.UpdateResponse;
import com.handson.labs.graphql.service.AuthorService;
import com.handson.labs.graphql.service.BookService;
import com.handson.labs.graphql.service.PublisherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    AuthorService authorService;

    @Autowired
    PublisherService publisherService;

    @SchemaMapping(typeName = "Library", field = "books")
    public List<Book> books(@Argument List<Integer> ids) {
        return bookService.getClientResults(ids);
    }

    @MutationMapping(name = "updateBooks")
    public UpdateResponse updateBooks(@Argument BookUpdate book, @Argument List<BookUpdate> books) {
        try {
            if (book != null) {
                if (book.getAuthor() != null) {
                    authorService.saveAuthor(authorService.buildAuthorEntity(book.getAuthor()));
                }
                if (book.getPublisher() != null) {
                    publisherService.savePublisher(publisherService.buildPublisherEntity(book.getPublisher()));
                }
                bookService.saveBook(bookService.buildBookEntity(book));
            }
            if (books != null && !books.isEmpty()) {
                for (BookUpdate b : books) {
                    if (b.getAuthor() != null) {
                        authorService.saveAuthor(authorService.buildAuthorEntity(b.getAuthor()));
                    }
                    if (b.getPublisher() != null) {
                        publisherService.savePublisher(publisherService.buildPublisherEntity(b.getPublisher()));
                    }
                    bookService.saveBook(bookService.buildBookEntity(b));
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
                .message("Books updated successfully")
                .build();
    }


}
