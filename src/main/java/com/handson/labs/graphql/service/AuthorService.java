package com.handson.labs.graphql.service;

import com.handson.labs.graphql.configuration.LibraryCache;
import com.handson.labs.graphql.entity.Author;
import com.handson.labs.graphql.entity.upsert.model.AuthorUpdate;
import com.handson.labs.graphql.repository.AuthorRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@Slf4j
@Getter
public class AuthorService extends RedisCacheService<Author> {

    private final AuthorRepository authorRepository;

    public AuthorService(RedisTemplate<String, Object> redisTemplate, AuthorRepository authorRepository) {
        super(redisTemplate, LibraryCache.AUTHORS, Author.class);
        this.authorRepository = authorRepository;
    }

    public List<Author> getAllAuthors(List<Integer> ids) {
        return (List<Author>) authorRepository.findAllById(ids);
    }

    @Override
    public Author getResultByPrimaryIdentifier(int id) {
        return authorRepository.findById(id).orElse(null);
    }

    //@CircuitBreaker(name = "authorService", fallbackMethod = "getAllAuthorsFallBack")
    public List<Author> getAllAuthors() {
        List<Author> authors = (List<Author>) authorRepository.findAll();
        writeToCache(authors);
        return authors;
    }

    // Must pass exception as parameter and return type should be same
//    public List<Author> getAllAuthorsFallBack(Exception exception) {
//        log.error("Author Service is not available", exception);
//        return Collections.emptyList();
//    }

    public void saveAuthor(Author author) {
        authorRepository.save(author);
        writeToCache(author, author.getId());
    }

    public void deleteAuthorById(Integer id) {
        authorRepository.deleteById(id);
    }

    public Author buildAuthorEntity(AuthorUpdate authorUpdate) {
        return Author.builder()
                .id(authorUpdate.getId())
                .name(authorUpdate.getName())
                .bio(authorUpdate.getBio())
                .build();
    }

    @Override
    protected List<Author> getClientResultFromClient(List<Integer> ids) {
        log.info("Fetching authors from DB for Ids : {}", ids);
        return getAllAuthors(ids);
    }

    @Override
    protected Integer getId(Author entity) {
        return entity.getId();
    }

}
