package com.handson.labs.graphql.service;

import com.handson.labs.graphql.configuration.LibraryCache;
import com.handson.labs.graphql.entity.Publisher;
import com.handson.labs.graphql.entity.upsert.model.PublisherUpdate;
import com.handson.labs.graphql.repository.PublisherRepository;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PublisherService extends RedisCacheService<Publisher> {

    public PublisherService(RedisTemplate<String, Object> redisTemplate) {
        super(redisTemplate, LibraryCache.PUBLISHERS, Publisher.class);
    }

    @Autowired
    private PublisherRepository publisherRepository;

    public Publisher getPublisherById(Integer id) {
        return publisherRepository.findById(id).orElse(null);
    }

    public void savePublisher(Publisher publisher) {
        publisherRepository.save(publisher);
    }

    public void deletePublisherById(Integer id) {
        publisherRepository.deleteById(id);
    }

    public List<Publisher> getAllPublishers() {
        return (List<Publisher>) publisherRepository.findAll();
    }

    public List<Publisher> getAllPublishers(List<Integer> ids) {
        return (List<Publisher>) publisherRepository.findAllById(ids);
    }



    public Publisher buildPublisherEntity(PublisherUpdate publisherUpdate) {
        return Publisher.builder()
                .id(publisherUpdate.getId())
                .name(publisherUpdate.getName())
                .country(publisherUpdate.getCountry())
                .build();
    }

    @Override
    protected List<Publisher> getAllFromClient(List<Integer> ids) {
        log.info("Fetching publishers from DB for Ids : {}", ids);
        return getAllPublishers(ids);
    }

    @Override
    protected Integer getId(Publisher entity) {
        return entity.getId();
    }

}
