package com.companyapp.companymicroservice.Repository;

import com.companyapp.companymicroservice.Entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository  extends JpaRepository<Company,Long> {
}
