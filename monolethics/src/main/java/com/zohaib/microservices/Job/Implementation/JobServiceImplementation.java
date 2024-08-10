package com.zohaib.microservices.Job.Implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zohaib.microservices.Job.Job;
import com.zohaib.microservices.Job.JobRepository;
import com.zohaib.microservices.Job.jobService;

@Service
public class JobServiceImplementation implements jobService {

    JobRepository jobRepository;

    public JobServiceImplementation(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean DeleteById(Long id) {
        try {
            jobRepository.deleteById(id);
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateJob(Long id, Job entity) {

        Optional<Job> jobOptional = jobRepository.findById(id);

        if (jobOptional.isPresent()) {
            Job job = jobOptional.get();
            job.setTitle(entity.getTitle());
            job.setDescription(entity.getDescription());
            job.setLocation(entity.getLocation());
            job.setMinSallery(entity.getMinSallery());
            job.setMaxSallery(entity.getMaxSallery());
            jobRepository.save(job);
            return true;
        }

        return false;
    }

}
