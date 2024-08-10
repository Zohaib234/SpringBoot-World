package com.zohaib.microservices.Reviews.Implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zohaib.microservices.Company.Company;
import com.zohaib.microservices.Company.CompanyRepository;
import com.zohaib.microservices.Reviews.Review;
import com.zohaib.microservices.Reviews.ReviewsRepository;
import com.zohaib.microservices.Reviews.ReviewsService;

@Service
public class ReviewsImplementation implements ReviewsService {

    private final ReviewsRepository repository;
    private final CompanyRepository companyRepository;

    public ReviewsImplementation(ReviewsRepository repository,CompanyRepository companyRep) {
        this.repository = repository;
        this.companyRepository = companyRep;
    }

    @Override
    public boolean createReview(Long companyId,Review review) {
       
        Company company = companyRepository.findById(companyId).orElse(null);
        
        if (company == null) {
            return false;
        }else{
            review.setCompany(company);
            repository.save(review);
            return true;
        }
        
    }

    @Override
    public List<Review> getReviews(Long companyId) {

        return repository.findByCompanyId(companyId);
    }

    @Override
    public Review getReviewById(Long companyId, Long reviewId) {
       
       List<Review> reviews = repository.findByCompanyId(companyId);

       return reviews.stream().filter(review -> review.getId().equals(reviewId)).findFirst().orElse(null);
    }

    @Override
    public boolean deleteReview(Long companyId, Long reviewId) {
       
        try {
            Review review = getReviewById(companyId, reviewId);
            if (review == null) {
                return false;
            }
            repository.delete(review);
            return true;
         } catch (Exception e) {
            return false;
         }
            
        } 

    @Override
    public boolean updateReview(Long companyId, Long reviewId, Review updatedReview) {
      
        Review review = getReviewById(companyId, reviewId);

        if (review == null) {
            return false;
        } else {
            review.setCompany(updatedReview.getCompany());
            review.setDescription(updatedReview.getDescription());
            review.setRating(updatedReview.getRating());
            review.setTitle(updatedReview.getTitle());
            repository.save(review);
            return true;
        }
       
    }


}
