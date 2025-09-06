package com.handson.labs.graphql.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.handson.labs.graphql.entity.Review;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Integer>, PagingAndSortingRepository<Review, Integer> {

    public Review findReviewByBookId(Integer bookId);

    public Review findReviewByUserId(Integer userId);

    public List<Review> findAllByUserIdIn(List<Integer> userIds);
}
