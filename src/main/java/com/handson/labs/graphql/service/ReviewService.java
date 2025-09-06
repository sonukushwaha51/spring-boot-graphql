package com.handson.labs.graphql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.handson.labs.graphql.entity.Review;
import com.handson.labs.graphql.repository.ReviewRepository;

@Service
public class ReviewService {

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

}
