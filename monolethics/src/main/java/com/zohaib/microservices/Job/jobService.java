package com.zohaib.microservices.Job;

import java.util.List;

public interface jobService {

    List<Job> getAllJobs();

    void createJob(Job job);

    Job getJobById(Long id);

    boolean DeleteById(Long id);

    boolean updateJob(Long id, Job entity);
}
