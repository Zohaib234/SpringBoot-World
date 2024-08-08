package com.zohaib.microservices.Reviews.Implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zohaib.microservices.Reviews.Review;
import com.zohaib.microservices.Reviews.ReviewsRepository;
import com.zohaib.microservices.Reviews.ReviewsService;

@Service
public class ReviewsImplementation implements ReviewsService {

    ReviewsRepository repository;

    public ReviewsImplementation(ReviewsRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createReview(Review review) {
       
        repository.save(review);
        
    }

    @Override
    public List<Review> getReviews() {

        return repository.findAll();
    }

    @Override
    public Review getReviewById(Long id) {

        throw new UnsupportedOperationException("Unimplemented method 'getReviewById'");
    }

    @Override
    public boolean deleteReview(Long id) {
       
        throw new UnsupportedOperationException("Unimplemented method 'deleteReview'");
    }

    @Override
    public boolean updateReview(Long id, Review review) {

        throw new UnsupportedOperationException("Unimplemented method 'updateReview'");
    }
}
