package com.embarxx.firstspringdemo.Jobs;


import com.embarxx.firstspringdemo.Companys.Company;
import jakarta.annotation.Generated;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
public class Job {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    public long id;
    public String title;
    public String description;
    public String minsalary;
    public String maxsalary;
    public String location;


    @ManyToOne
    public Company company;

    public Job(long id) {
        this.id = id;
    }

    public Job() {
    }

    public Job(long id, String title, String description, String minsalary, String maxsalary, String location) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.minsalary = minsalary;
        this.maxsalary = maxsalary;
        this.location = location;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMinsalary() {
        return minsalary;
    }

    public void setMinsalary(String minsalary) {
        this.minsalary = minsalary;
    }

    public String getMaxsalary() {
        return maxsalary;
    }

    public void setMaxsalary(String maxsalary) {
        this.maxsalary = maxsalary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}


