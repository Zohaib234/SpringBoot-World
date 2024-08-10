package com.zohaib.microservices.Reviews;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewsRepository extends JpaRepository<Review,Long> {

    List<Review> findByCompanyId(Long companyId);

}
