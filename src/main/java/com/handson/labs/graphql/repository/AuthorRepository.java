package com.handson.labs.graphql.repository;

import com.handson.labs.graphql.entity.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Integer>, PagingAndSortingRepository<Author, Integer> {
}
