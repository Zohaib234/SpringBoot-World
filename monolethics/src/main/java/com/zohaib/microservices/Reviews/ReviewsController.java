package com.zohaib.microservices.Reviews;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewsController {

    ReviewsService service;

    public ReviewsController(ReviewsService service) {
        this.service = service;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId) {
        return new ResponseEntity<List<Review>>(service.getReviews(companyId), HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> createReview(@PathVariable Long companyId, @RequestBody Review entity) {
        boolean isReviewSaved = service.createReview(companyId, entity);
        if (isReviewSaved) {

            return new ResponseEntity<>("Review created successfully", HttpStatus.CREATED);
        } else {

            return new ResponseEntity<>("company does not exist", HttpStatus.NOT_FOUND);

        }

    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long companyId, @PathVariable Long reviewId)
            throws Exception {

        try {
            return new ResponseEntity<>(service.getReviewById(companyId, reviewId), HttpStatus.OK);
        } catch (Exception e) {

            throw new Exception("review not found" + e);
        }

    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long companyId, @PathVariable Long reviewId) {
        boolean isDeleted = service.deleteReview(companyId, reviewId);
        if (isDeleted) {
            return new ResponseEntity<>("Review deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Review not found", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long companyId, @PathVariable Long reviewId,
            @RequestBody Review entity) {
        boolean isUpdated = service.updateReview(companyId, reviewId, entity);
        if (isUpdated) {
            return new ResponseEntity<>("Review updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Review not found", HttpStatus.NOT_FOUND);
        }
    }

}
