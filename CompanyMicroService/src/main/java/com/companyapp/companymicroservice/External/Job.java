package com.companyapp.companymicroservice.External;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity
public class Job {
    @Id
    private Long id;
    private String title;
    private String description;
    private Long companyId;

}
