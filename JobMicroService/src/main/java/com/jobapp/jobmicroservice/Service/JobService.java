package com.jobapp.jobmicroservice.Service;

import com.jobapp.jobmicroservice.Entity.Job;

import java.util.List;

public interface JobService {
    public   List<Job> getAllJobs();
    public  Job getJob(Long id);
    boolean deleteJob(Long id);
    boolean updateJob(Long id, Job job) throws Exception;
    boolean createJob(Job job);
}
