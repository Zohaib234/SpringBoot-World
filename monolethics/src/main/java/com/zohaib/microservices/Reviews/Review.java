package com.zohaib.microservices.Reviews;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zohaib.microservices.Company.Company;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Review {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private double rating;
    
    @JsonIgnore
    @ManyToOne
    private Company company;
    

}
