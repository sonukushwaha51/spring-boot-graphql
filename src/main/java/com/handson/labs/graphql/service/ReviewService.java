package com.handson.labs.graphql.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.handson.labs.graphql.configuration.LibraryCache;
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
        return (List<Review>) reviewRepository.findAll();
    }

    public Review getReviewById(Integer id) {
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
    protected List<Review> getAllFromClient(List<Integer> ids) {
        log.info("Fetching reviews from DB for Ids : {}", ids);
        return getAllReviewsByIds(ids);
    }

    @Override
    public List<Review> getResultByParentIds(List<Integer> ids, String parentFieldName) {
        log.info("Fetching reviews from DB for {} Ids : {} ", parentFieldName, ids);
        if (parentFieldName.equals("users")) {
            return getReviewsByUserId(ids);
        }
        return new ArrayList<>();
    }

    @Override
    protected Integer getId(Review entity) {
        return entity.getId();
    }

}
