package com.embarxx.firstspringdemo.Companys.impl;

import com.embarxx.firstspringdemo.Companys.Company;
import com.embarxx.firstspringdemo.Companys.CompanyRepository;
import com.embarxx.firstspringdemo.Companys.Companyservice;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import com.embarxx.firstspringdemo.Jobs.Job;

@Service
public class  companyserviceimpl implements Companyservice {
    private CompanyRepository companyRepository;

    public companyserviceimpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }


    @Override
    public List<Company> getallcompanies() {
        return companyRepository.findAll();
    }

    @Override
    public boolean updatecompany(Company company, Long id) {
        Optional<Company>companyOptional=companyRepository.findById(id);
        if(companyOptional.isPresent()){
            Company companytoupdate=companyOptional.get();
            companytoupdate.setNames(company.getNames());
            companytoupdate.setDescription(company.getDescription());
            companytoupdate.setJobs(company.getJobs());
            companyRepository.save(companytoupdate);
            return true;
        }
        return false;
    }

    @Override
    public void createcompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public boolean deletecompanybyid(Long id) {
        if(companyRepository.existsById(id)){
            companyRepository.deleteById(id);
            return true;
        }
         return false;
    }

    @Override
    public Company getcompanybyid(Long id) {
        return companyRepository.findById(id).orElse(null);
    }
}
