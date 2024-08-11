package com.jobapp.jobmicroservice.Repository;

import com.jobapp.jobmicroservice.Entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository  extends JpaRepository<Job, Long> {
}
