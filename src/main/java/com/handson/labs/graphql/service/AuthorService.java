package com.handson.labs.graphql.service;

import com.handson.labs.graphql.entity.Author;
import com.handson.labs.graphql.entity.upsert.model.AuthorUpdate;
import com.handson.labs.graphql.repository.AuthorRepository;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@Getter
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Cacheable("authors")
    public List<Author> getAllAuthors(List<Integer> ids) {
        return (List<Author>) authorRepository.findAllById(ids);
    }

    @Cacheable(value = "authors", key = "#id")
    public Author getAuthorById(Integer id) {
        log.info("Getting author from DB: {}", id);
        return authorRepository.findById(id).orElse(null);
    }

    @Cacheable("authors")
    public List<Author> getAllAuthors() {
        return (List<Author>) authorRepository.findAll();
    }
    
    @CachePut(value = "authors", key = "#result.id")
    public void saveAuthor(Author author) {
        authorRepository.save(author);
    }

    @CacheEvict(value = "authors", key = "#id")
    public void deleteAuthorById(Integer id) {
        log.info("Deleted author from DB: {}", id);
        authorRepository.deleteById(id);
    }

    public Author buildAuthorEntity(AuthorUpdate authorUpdate) {
        return Author.builder()
                .id(authorUpdate.getId())
                .name(authorUpdate.getName())
                .bio(authorUpdate.getBio())
                .build();
    }

}
