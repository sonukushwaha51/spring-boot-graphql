package com.handson.labs.graphql.service;

import com.handson.labs.graphql.configuration.LibraryCache;
import com.handson.labs.graphql.entity.Book;
import com.handson.labs.graphql.entity.upsert.model.BookUpdate;
import com.handson.labs.graphql.repository.BookRepository;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter
@Slf4j
public class BookService extends RedisCacheService<Book> {

    @Autowired
    private BookRepository bookRepository;

    public BookService(RedisTemplate<String, Object> redisTemplate) {
        super(redisTemplate,LibraryCache.BOOKS, Book.class);
    }

    public List<Book> getAllBooks() {
        return (List<Book>) bookRepository.findAll();
    }

    public List<Book> getAllBooksByIds(List<Integer> ids) {
        return (List<Book>) bookRepository.findAllById(ids);
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

    @Override
    protected List<Book> getAllFromClient(List<Integer> ids) {
        log.info("Fetching books from DB for Ids : {}", ids);
        return getAllBooksByIds(ids);
    }

    @Override
    public List<Book> getResultByParentIds(List<Integer> ids, String parentFieldName) {
        log.info("Fetching books from DB for {} Ids : {} ", parentFieldName, ids);
        if (parentFieldName.equals("authors")) {
            return getAllBooksByAuthorIds(ids);
        }
        return new ArrayList<>();
    }

}
