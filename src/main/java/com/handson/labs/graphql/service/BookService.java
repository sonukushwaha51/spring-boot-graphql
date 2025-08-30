package com.handson.labs.graphql.service;

import com.handson.labs.graphql.entity.Book;
import com.handson.labs.graphql.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return (List<Book>) bookRepository.findAll();
    }

    public List<Book> getAllBooksByAuthorIds(List<Integer> ids) {
        return (List<Book>) bookRepository.findAllByAuthorIdIn(ids);
    }

}
