package com.zohaib.microservices.Job;

import com.zohaib.microservices.Company.Company;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String title;
    private String location;
    private String description;
    private String minSallery;
    private String maxSallery;

    @ManyToOne()
    private Company company;

}
