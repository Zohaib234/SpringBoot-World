package com.zohaib.microservices.Company;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zohaib.microservices.Job.Job;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    private List<Job> jobs;
}
