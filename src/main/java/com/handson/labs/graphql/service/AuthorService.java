package com.handson.labs.graphql.service;

import com.handson.labs.graphql.configuration.LibraryCache;
import com.handson.labs.graphql.entity.Author;
import com.handson.labs.graphql.entity.upsert.model.AuthorUpdate;
import com.handson.labs.graphql.repository.AuthorRepository;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@Getter
public class AuthorService extends RedisCacheService<Author> {

    public AuthorService(RedisTemplate<String, Object> redisTemplate) {
        super(redisTemplate,LibraryCache.AUTHORS, Author.class);
    }

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAllAuthors(List<Integer> ids) {
        return (List<Author>) authorRepository.findAllById(ids);
    }

    public Author getAuthorById(Integer id) {
        return authorRepository.findById(id).orElse(null);
    }

    public List<Author> getAllAuthors() {
        return (List<Author>) authorRepository.findAll();
    }

    public void saveAuthor(Author author) {
        authorRepository.save(author);
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
    protected List<Author> getAllFromClient(List<Integer> ids) {
        log.info("Fetching authors from DB for Ids : {}", ids);
        return getAllAuthors(ids);
    }

}
