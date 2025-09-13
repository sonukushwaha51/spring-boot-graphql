package com.handson.labs.graphql.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.handson.labs.graphql.configuration.LibraryCache;
import com.handson.labs.graphql.entity.Book;
import com.handson.labs.graphql.entity.Review;
import com.handson.labs.graphql.repository.ReviewRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ReviewService extends RedisCacheService<Review> {

    public ReviewService(RedisTemplate<String, Object> redisTemplate) {
        super(redisTemplate, LibraryCache.REVIEWS, Review.class);
    }

    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> getAllReviews() {
        List<Review> reviews = (List<Review>) reviewRepository.findAll();
        writeToCache(reviews);
        return reviews;
    }

    @Override
    public Review getResultByPrimaryIdentifier(int id) {
        return reviewRepository.findById(id).orElse(null);
    }

    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }

    public void deleteReviewById(Integer id) {
        reviewRepository.deleteById(id);
    }

    public Review getReviewByBookId(Integer bookId) {
        return reviewRepository.findReviewByBookId(bookId);
    }

    public Review getReviewByUserId(Integer userId) {
        return reviewRepository.findReviewByUserId(userId);
    }

    public List<Review> getReviewsByUserId(List<Integer> userIds) {
        return reviewRepository.findAllByUserIdIn(userIds);
    }
    public List<Review> getAllReviewsByIds(List<Integer> ids) {
        return (List<Review>) reviewRepository.findAllById(ids);
    }

    @Override
    protected List<Review> getClientResultFromClient(List<Integer> ids) {
        log.info("Fetching reviews from DB for Ids : {}", ids);
        return getAllReviewsByIds(ids);
    }

    @Override
    public List<Review> getResultListFromParentIdFromClient(List<Integer> ids) {
        log.info("Fetching books from DB for {} Ids : {} ", ids);
        return getReviewsByUserId(ids);
    }

    @Override
    protected Integer getId(Review entity) {
        return entity.getId();
    }

}
