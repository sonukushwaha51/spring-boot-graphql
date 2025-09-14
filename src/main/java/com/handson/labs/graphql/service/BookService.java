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
        List<Book> books = (List<Book>) bookRepository.findAll();
        writeToCache(books);
        return books;
    }
        

    public List<Book> getAllBooksByIds(List<Integer> ids) {
        return (List<Book>) bookRepository.findAllById(ids);
    }

    public List<Book> getAllBooksByAuthorIds(List<Integer> ids) {
        return (List<Book>) bookRepository.findAllByAuthorIdIn(ids);
    }

    @Override
    public Book getResultByPrimaryIdentifier(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    public void saveBook(Book book) throws Exception {
        bookRepository.save(book);
        writeToCache(book, book.getId());
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
    protected List<Book> getClientResultFromClient(List<Integer> ids) {
        log.info("Fetching books from DB for Ids : {}", ids);
        return getAllBooksByIds(ids);
    }

    @Override
    public List<Book> getResultListFromParentIdFromClient(List<Integer> ids) {
        log.info("Fetching books from DB for {} Ids : {} ", ids);
        return getAllBooksByAuthorIds(ids);
    }

    @Override
    protected Integer getId(Book entity) {
        return entity.getId();
    }

}
