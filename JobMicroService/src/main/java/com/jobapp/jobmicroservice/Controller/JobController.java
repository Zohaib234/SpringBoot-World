package com.jobapp.jobmicroservice.Controller;

import com.jobapp.jobmicroservice.Entity.Job;
import com.jobapp.jobmicroservice.Service.JobService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Data
@RequestMapping("/jobs")
public class JobController {
    JobService jobService;
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public ResponseEntity<List<Job>> getJobList(){
        return  new ResponseEntity<List<Job>>(jobService.getAllJobs(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody  Job job){
        if(jobService.createJob(job)){
            return new ResponseEntity<>("Job created successfully", HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>("Failed to create job", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id) throws Exception {
        Job job = jobService.getJob(id);
        if(job!=null){
            return new ResponseEntity<Job>(job, HttpStatus.OK);
        } else {
            throw  new Exception("Job not found");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateJob(@PathVariable Long id, @RequestBody Job job) throws Exception {
        if(jobService.updateJob(id, job)){
            return new ResponseEntity<>("Job updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to update job", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id) throws Exception {
        if(jobService.deleteJob(id)){
            return new ResponseEntity<>("Job deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to delete job", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
