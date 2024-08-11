package com.companyapp.companymicroservice.Implementation;

import com.companyapp.companymicroservice.Entity.Company;
import com.companyapp.companymicroservice.External.Job;
import com.companyapp.companymicroservice.Repository.CompanyRepository;
import com.companyapp.companymicroservice.Service.CompanyService;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
@Service
@Data
public class CompanyServiceImpl implements CompanyService {

    CompanyRepository repository;
    CompanyServiceImpl(CompanyRepository repository){
        this.repository = repository;
    }

    @Override
    public List<Company> getCompanies() {
        return repository.findAll();
    }

    @Override
    public Company getCompanyById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public boolean createCompany(Company company) {
        try{
            RestTemplate template = new RestTemplate();
            Job job = template.getForObject("http://localhost:8081/jobs/1", Job.class);
           company.setJobId(job.getId());
           repository.save(company);
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage().toString());
            return  false;
        }
    }

    @Override
    public boolean updateCompany(Long id, Company company) {
        Company company1 = repository.findById(id).orElse(null);
        if(company1!=null){
            company1.setName(company.getName());
            company1.setDescription(company.getDescription());
            repository.save(company1);
            return true;
        }else {
            return  false;
        }
    }

    @Override
    public boolean deleteCompany(Long id) {
        if(repository.findById(id).orElse(null)==null){
            return  false;
        }else{
            repository.deleteById(id);
            return true;
        }
    }

    @Override
    public boolean DeleteAll() {
        try {
            repository.deleteAll();
            return  true;
        }catch (Exception e){
            return  false;
        }
    }
}
