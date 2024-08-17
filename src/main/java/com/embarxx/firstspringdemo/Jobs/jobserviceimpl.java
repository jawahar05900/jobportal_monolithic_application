package com.embarxx.firstspringdemo.Jobs;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class jobserviceimpl implements  Jobservice {
    private List<Job> jobs = new ArrayList<>();

    public List<Job> findall() {
        return jobs;
    }

    public void create(Job job) {
        jobs.add(job);
    }

    public Job getjobbyid(long id) {
        for (Job job : jobs) {
            if (job.getId() == id) {
                return job;
            }
        }
        return null;

    }

    public boolean deletejob(long id) {
        Iterator<Job> iterator = jobs.iterator();
        while (iterator.hasNext()) {
            Job job = iterator.next();

            if (job.getId() == id) {
                iterator.remove();
                return true;
            }


        }
        return false;

    }

    public boolean updatejobbyid(long id, Job updatedjob) {

        for (Job job : jobs) {
            if (job.getId() == id) {
                job.setTitle(updatedjob.getTitle());
                job.setDescription(updatedjob.getDescription());
                job.setMaxsalary(updatedjob.getMaxsalary());
                job.setMinsalary(updatedjob.getMinsalary());
                job.setLocation(updatedjob.getLocation());
                return true;
            }

        }
        return false;
    }
}




