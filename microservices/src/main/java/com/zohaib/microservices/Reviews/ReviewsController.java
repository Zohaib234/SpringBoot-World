package com.zohaib.microservices.Reviews;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewsController {
  
    ReviewsService service;

    public ReviewsController(ReviewsService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<Review>> getAllReviews() {
        return new ResponseEntity<List<Review>>(service.getReviews(),HttpStatus.OK);    
    }
    
    @PostMapping()
    public ResponseEntity<String> createReview(@RequestBody Review entity) {
       service.createReview(entity);

       return new ResponseEntity<>("Review created successfully",HttpStatus.CREATED);
    }
    
}
