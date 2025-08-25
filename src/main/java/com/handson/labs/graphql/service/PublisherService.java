package com.handson.labs.graphql.service;

import com.handson.labs.graphql.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;
}
