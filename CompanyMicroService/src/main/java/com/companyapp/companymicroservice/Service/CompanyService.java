package com.companyapp.companymicroservice.Service;

import com.companyapp.companymicroservice.Entity.Company;

import java.util.List;

public interface CompanyService {

    List<Company> getCompanies();
    Company getCompanyById(Long id);
    boolean createCompany(Company company);
    boolean updateCompany(Long id, Company company);
    boolean deleteCompany(Long id);
    boolean DeleteAll();

}
