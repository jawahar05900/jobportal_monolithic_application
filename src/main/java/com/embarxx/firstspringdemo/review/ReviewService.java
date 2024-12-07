package com.embarxx.firstspringdemo.review;



import java.util.List;

public interface ReviewService {
    List<Review> getallreviews(Long companyid);
    boolean addreview(Long companyid,Review review);
    Review getreview(Long companyid,Long reviewid);
    boolean updatereview(Long companyid,long reviewid,Review review);
    boolean deletereview(long companyid,long reviewid);

}
