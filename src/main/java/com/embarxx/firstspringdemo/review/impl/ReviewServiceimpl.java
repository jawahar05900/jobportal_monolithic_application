package com.embarxx.firstspringdemo.review.impl;

import com.embarxx.firstspringdemo.Companys.Company;
import com.embarxx.firstspringdemo.Companys.Companyservice;
import com.embarxx.firstspringdemo.review.Review;
import com.embarxx.firstspringdemo.review.ReviewRepository;
import com.embarxx.firstspringdemo.review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ReviewServiceimpl implements  ReviewService {
    private final ReviewRepository reviewRespository;
    private final Companyservice companyservice;

    public ReviewServiceimpl(ReviewRepository reviewRespository,Companyservice companyservice) {
        this.reviewRespository = reviewRespository;
        this.companyservice=companyservice;
    }

    @Override
    public List<Review> getallreviews(Long companyid) {
        List<Review>reviews=reviewRespository.findBycompanyId(companyid);
        return reviews;
    }

    @Override
    public boolean addreview(Long companyid, Review review) {
         Company company=companyservice.getcompanybyid(companyid);
         if(company!=null){
             review.setCompany(company);
             reviewRespository.save(review);
             return true;
         }
         else {
             return false;
         }

    }

    @Override
    public Review getreview(Long companyid, Long reviewid) {
        List<Review>reviews=reviewRespository.findBycompanyId(companyid);
        return reviews.stream().
                filter(review -> review.getId().equals(reviewid)).
                findFirst().orElse(null);

    }

    @Override
    public boolean updatereview(Long companyid, long reviewid, Review review) {
        if (companyservice.getcompanybyid(companyid) != null) {
            review.setCompany(companyservice.getcompanybyid(companyid));
            review.setId(reviewid);
            reviewRespository.save(review);
            return true;

        } else {
            return false;
        }
    }

    @Override
    public boolean deletereview(long companyid, long reviewid) {
        if (companyservice.getcompanybyid(companyid) != null && reviewRespository.existsById(reviewid)) {
            Review review = reviewRespository.findById(reviewid).orElse(null);
            Company company = review.getCompany();
            company.getReview().remove(review);
            companyservice.updatecompany(company, companyid);
            review.setCompany(null);
            reviewRespository.deleteById(reviewid);
            return true;


        } else {

            return false;
        }

    }
}
