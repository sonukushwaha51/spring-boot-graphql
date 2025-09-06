package com.handson.labs.graphql.service;

import com.handson.labs.graphql.entity.Book;
import com.handson.labs.graphql.entity.upsert.model.BookUpdate;
import com.handson.labs.graphql.repository.BookRepository;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return (List<Book>) bookRepository.findAll();
    }

    public List<Book> getAllBooksByAuthorIds(List<Integer> ids) {
        return (List<Book>) bookRepository.findAllByAuthorIdIn(ids);
    }

    public Book getBookById(Integer id) {
        return bookRepository.findById(id).orElse(null);
    }

    public void saveBook(Book book) throws Exception {
        bookRepository.save(book);
    }

    public void deleteBookById(Integer id) {
        bookRepository.deleteById(id);
    }

    public Book getBookByAuthorId(Integer authorId) {
        return bookRepository.findByAuthorId(authorId);
    }

    public Book buildBookEntity(BookUpdate bookUpdate) {

        return Book.builder()
                .id(bookUpdate.getId())
                .title(bookUpdate.getTitle())
                .isbn(bookUpdate.getIsbn())
                .authorId(bookUpdate.getAuthor() != null ? bookUpdate.getAuthor().getId() : null)
                .publisherId(bookUpdate.getPublisher() != null ? bookUpdate.getPublisher().getId() : null)
                .publishedYear(bookUpdate.getPublishedYear())
                .build();
    }

}
