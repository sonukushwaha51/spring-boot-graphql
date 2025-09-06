package com.handson.labs.graphql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;

import com.handson.labs.graphql.entity.Review;
import com.handson.labs.graphql.entity.upsert.model.ReviewUpdate;
import com.handson.labs.graphql.entity.upsert.model.UpdateResponse;
import com.handson.labs.graphql.service.ReviewService;

@Controller
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @SchemaMapping(typeName = "Library", field = "reviews")
    public List<Review> getAllReviews(@Argument List<Integer> ids) {
        return reviewService.getAllReviewsByIds(ids);
    }

    @MutationMapping(name = "createReview")
    public UpdateResponse createOrUpdateReview(@Argument ReviewUpdate review) {
        try {
            reviewService.saveReview(Review.builder()
                    .id(review.getId())
                    .bookId(review.getBookId())
                    .userId(review.getUserId())
                    .rating(review.getRating())
                    .comments(review.getComment())
                    .build());
        } catch (Exception e) {
            return UpdateResponse.builder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .message("Error creating/updating review: " + e.getMessage())
                    .build();
        }
        return UpdateResponse.builder()
                .status(HttpStatus.OK.value())
                .message("Review created/updated successfully")
                .build();
    }

}
