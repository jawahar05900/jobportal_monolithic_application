package com.embarxx.firstspringdemo.Companys;

import com.embarxx.firstspringdemo.Jobs.Job;
import com.embarxx.firstspringdemo.review.Review;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.lang.NonNull;

import java.util.List;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String names;
    private String description;


    @JsonIgnore
    @OneToMany(mappedBy = "company")
    public List<Job>jobs;

    @JsonIgnore
    @OneToMany(mappedBy = "company")
    public List<Review>review;

    public Company() {
    }

    public Company(long id, String names, String description, List<Job> jobs) {
        this.id = id;
        this.names = names;
        this.description = description;
        this.jobs = jobs;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public List<Review> getReview() {
        return review;
    }

    public void setReview(List<Review> review) {
        this.review = review;
    }
}
