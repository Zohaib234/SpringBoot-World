package com.zohaib.microservices.Company;

import java.util.List;

public interface CompanyService {

    List<Company> getAllCompanies();
    void createCompany(Company company);
    Company getCompanyById(Long id);
    boolean deleteById(Long id);
    boolean updateCompany(Long id, Company entity);
    
}
