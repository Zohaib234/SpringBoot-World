package com.zohaib.microservices.Reviews;

import java.util.List;

public interface ReviewsService {

    boolean createReview( Long companyId,Review review);
    List<Review> getReviews(Long companyId);
    Review getReviewById(Long companyId, Long reviewId);
    boolean deleteReview(Long companyId, Long reviewId);
    boolean updateReview(Long companyId, Long reviewId, Review updatedReview);
}
