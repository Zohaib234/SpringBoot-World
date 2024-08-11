package com.companyapp.companymicroservice.Controller;

import com.companyapp.companymicroservice.Entity.Company;
import com.companyapp.companymicroservice.Service.CompanyService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
@Data
public class CompanyController {

    CompanyService service;
    CompanyController(CompanyService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Company>> getCompanyList(){
        return ResponseEntity.ok(service.getCompanies());
    }

    @PostMapping
    public ResponseEntity<String> createCompany(@RequestBody Company company){
        if(service.createCompany(company)){
            return ResponseEntity.status(201).body("Company created successfully");
        } else {
            return ResponseEntity.status(500).body("Failed to create company");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id) throws Exception {
        Company company = service.getCompanyById(id);
        if(company!=null){
            return new ResponseEntity<Company>(company, HttpStatus.OK);
        } else {
            throw  new Exception("Company not found");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody Company company){
        if(service.updateCompany(id, company)){
            return ResponseEntity.status(200).body("Company updated successfully");
        } else {
            return ResponseEntity.status(500).body("Failed to update company");
        }
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<String> deleteCompany(@PathVariable Long id){
        if(service.deleteCompany(id)){
            return ResponseEntity.status(200).body("Company deleted successfully");
        } else {
            return ResponseEntity.status(500).body("Failed to delete company");
        }
    }

    @PostMapping("/delete")
    public  ResponseEntity<String> deleteAll(){
        if(service.DeleteAll()){
            return ResponseEntity.status(200).body("All companies deleted successfully");
        } else {
            return ResponseEntity.status(500).body("Failed to delete all companies");
        }
    }
}
