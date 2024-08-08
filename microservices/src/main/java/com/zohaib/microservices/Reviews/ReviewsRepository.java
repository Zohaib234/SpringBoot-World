package com.zohaib.microservices.Reviews;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewsRepository extends JpaRepository<Review,Long> {

}
