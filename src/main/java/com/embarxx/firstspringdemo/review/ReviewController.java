package com.embarxx.firstspringdemo.review;

import com.embarxx.firstspringdemo.Companys.Company;
import jakarta.persistence.GeneratedValue;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyid}")
public class ReviewController {
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getallreviews(@PathVariable Long companyid){
        return new ResponseEntity<>(reviewService.getallreviews(companyid), HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> addreview(@PathVariable Long companyid,@RequestBody Review review){
        boolean isreviewupdate= reviewService.addreview(companyid,review);
        if(isreviewupdate){
            return new ResponseEntity<>("Review added successfully",HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Review not added",HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/reviews/{reviewid}")
    public ResponseEntity<Review>getreview(@PathVariable Long companyid,@PathVariable Long reviewid){
        return new ResponseEntity<>(reviewService.getreview(companyid, reviewid),HttpStatus.OK);
    }
    @PutMapping("/reviews/{reviewid}")
    public ResponseEntity<String> updatereview(@PathVariable long companyid,@PathVariable long reviewid,@RequestBody Review review){
        boolean isreviewupdated= reviewService.updatereview(companyid,reviewid,review);
        if(isreviewupdated){
            return new ResponseEntity<>("review updated successfully",HttpStatus.OK);

        }
        else {
            return new ResponseEntity<>("review not updated",HttpStatus.OK);
        }
    }
    @DeleteMapping("/reviews/{reviewid}")
    public ResponseEntity<String> deletereview(@PathVariable long companyid,@PathVariable long reviewid) {
        boolean isreviewdeleted = reviewService.deletereview(companyid, reviewid);
        if(isreviewdeleted){
            return new ResponseEntity<>("review deleted successfully",HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("review not deleted",HttpStatus.NOT_FOUND);
        }
    }
}
