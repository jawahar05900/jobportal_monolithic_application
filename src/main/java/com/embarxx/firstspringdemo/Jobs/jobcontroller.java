package com.embarxx.firstspringdemo.Jobs;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class jobcontroller {
    Jobservice jobservice;

    public jobcontroller(Jobservice jobservice) {
        this.jobservice = jobservice;
    }

    @GetMapping("/job")
    public ResponseEntity<List<Job>> findall(){
        return ResponseEntity.ok(jobservice.findall());
    }

    @PostMapping("/job")
    public ResponseEntity<String> createall(@RequestBody Job job){
        jobservice.create(job);
        return new ResponseEntity<>("jobadded success", HttpStatus.OK);
    }

    @PostMapping("/job/{id}")
    public ResponseEntity<Job> getjobbyid(@PathVariable long id){
        Job jobs=jobservice.getjobbyid(id);
        if(jobs!=null)
            return new ResponseEntity<>(jobs,HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/job/{id}")
    public ResponseEntity<String> deletejobbyid(@PathVariable long id){
        boolean delete=jobservice.deletejob(id);
        if(delete)
            return new ResponseEntity<>("job deleted successfully",HttpStatus.OK);
        return new ResponseEntity<>("error",HttpStatus.NOT_FOUND);
    }
    @PutMapping("/job/{id}")
    public ResponseEntity<String> update(@PathVariable long id,@RequestBody Job updatedjob){
        boolean update=jobservice.updatejobbyid(id,updatedjob);
        if(update)
            return new ResponseEntity<>("job updated successfully",HttpStatus.OK);
        return new ResponseEntity<>("job not updated successfully",HttpStatus.NOT_FOUND);
    }

}