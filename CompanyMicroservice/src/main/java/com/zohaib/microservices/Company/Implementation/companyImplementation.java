package com.zohaib.microservices.Company.Implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zohaib.microservices.Company.Company;
import com.zohaib.microservices.Company.CompanyRepository;
import com.zohaib.microservices.Company.CompanyService;

import lombok.Data;

@Service
@Data
public class companyImplementation implements CompanyService {

    CompanyRepository companyRepository;

    public companyImplementation(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public Company getCompanyById(Long id) {

        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteById(Long id) {
        try {
            companyRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateCompany(Long id, Company entity) {

        try {

            Company company = companyRepository.findById(id).orElse(null);

            company.setName(entity.getName());
            company.setDescription(entity.getDescription());
            company.setJobs(entity.getJobs());
            companyRepository.save(company);

            return true;

        } catch (Exception e) {
            return false;
        }

    }

}
