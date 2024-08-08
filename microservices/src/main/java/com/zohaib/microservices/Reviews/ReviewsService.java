package com.zohaib.microservices.Reviews;

import java.util.List;

public interface ReviewsService {

    void createReview(Review review);
    List<Review> getReviews();
    Review getReviewById(Long id);
    boolean deleteReview(Long id);
    boolean updateReview(Long id, Review review);
}
