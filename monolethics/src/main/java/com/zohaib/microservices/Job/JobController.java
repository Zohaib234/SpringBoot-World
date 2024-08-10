package com.zohaib.microservices.Job;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private jobService jobService;

    public JobController(jobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public ResponseEntity<List<Job>> getAllJobs() {

        return ResponseEntity.ok(jobService.getAllJobs());
    }

    @PostMapping
    public ResponseEntity<String> CreateJob(@RequestBody Job entity) {

        jobService.createJob(entity);

        return new ResponseEntity<>("job created successfully", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getbyId(@PathVariable Long id) {
        Job job = jobService.getJobById(id);

        return new ResponseEntity<>(job, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> DeleteById(@PathVariable Long id) {

        boolean isDeleted = jobService.DeleteById(id);
        if (isDeleted) {

            return new ResponseEntity<>("job deleted successfully", HttpStatus.OK);
        }

        return new ResponseEntity<>("job not found", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> putMethodName(@PathVariable Long id, @RequestBody Job entity) {

        boolean isUpdated = jobService.updateJob(id, entity);

        if (isUpdated) {

            return new ResponseEntity<>("Job Updated successfully", HttpStatus.OK);
        }

        return new ResponseEntity<>("job not found", HttpStatus.NOT_FOUND);

    }

}
