package com.handson.labs.graphql.repository;

import com.handson.labs.graphql.entity.Publisher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends CrudRepository<Publisher, Integer>, PagingAndSortingRepository<Publisher, Integer> {
}
