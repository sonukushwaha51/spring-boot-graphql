package com.handson.labs.graphql.repository;

import com.handson.labs.graphql.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer>, PagingAndSortingRepository<Book, Integer> {

    public List<Book> findAllByAuthorIdIn(List<Integer> ids);

    public Book findByAuthorId(Integer authorId);
}
