package com.handson.labs.graphql.repository;

import com.handson.labs.graphql.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer>, PagingAndSortingRepository<Category, Integer> {
}
