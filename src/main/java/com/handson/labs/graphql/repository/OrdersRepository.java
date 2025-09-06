package com.handson.labs.graphql.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.handson.labs.graphql.entity.Orders;

@Repository
public interface OrdersRepository extends CrudRepository<Orders, Integer>, PagingAndSortingRepository<Orders, Integer>  {

}