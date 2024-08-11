package com.jobapp.jobmicroservice.Implementation;

import com.jobapp.jobmicroservice.Entity.Job;
import com.jobapp.jobmicroservice.Repository.JobRepository;
import com.jobapp.jobmicroservice.Service.JobService;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
@Service
@Data
public class JobServiceImpl  implements JobService {
    JobRepository jobRepository;
    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }


    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    @Override
    public Job getJob(Long id) {
       Job job = jobRepository.findById(id).orElse(null);
       if (job == null) {
           try {
               throw  new NoSuchFieldException("job not found");
           } catch (NoSuchFieldException e) {
               throw new RuntimeException(e);
           }
       }else {
           return job;
       }


    }

    @Override
    public boolean deleteJob(Long id) {
        try {
            jobRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean updateJob(Long id, Job updatedJob) throws  Exception  {
        Job job  = jobRepository.findById(id).orElse(null);
        if (job == null){
            throw new Exception("Job not found");
        }else{
            job.setTitle(updatedJob.getTitle());
            job.setDescription(updatedJob.getDescription());
            job.setCompanyId(updatedJob.getCompanyId());
            jobRepository.save(job);
            return true;
        }
    }

    @Override
    public boolean createJob(Job job) {
       try{
         jobRepository.save(job);
         return true;
       }catch (Exception e){
           return false;
       }
    }
}
