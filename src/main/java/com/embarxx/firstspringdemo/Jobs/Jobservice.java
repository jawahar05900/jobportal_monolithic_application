package com.embarxx.firstspringdemo.Jobs;

import java.util.List;

public interface Jobservice {
    List<Job> findall();
    void create(Job job);
    Job getjobbyid(long id);
    boolean deletejob (long id);
    boolean updatejobbyid(long id,Job updatedjob);
}
