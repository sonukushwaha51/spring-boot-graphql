package com.handson.labs.graphql.service;

import com.handson.labs.graphql.entity.Author;
import com.handson.labs.graphql.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAllAuthors(List<Integer> ids) {
        return (List<Author>) authorRepository.findAllById(ids);
    }
}
