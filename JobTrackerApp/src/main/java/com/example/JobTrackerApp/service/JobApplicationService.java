package com.example.JobTrackerApp.service;


import com.example.JobTrackerApp.entity.JobApplication;
import com.example.JobTrackerApp.repo.JobApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobApplicationService {
    @Autowired
    private JobApplicationRepository repository;

    public List<JobApplication> getAllApplications() {
        return repository.findAll();
    }

    public Optional<JobApplication> getApplicationById(Long id) {
        return repository.findById(id);
    }

    public JobApplication saveApplication(JobApplication application) {
        return repository.save(application);
    }

    public void deleteApplication(Long id) {
        repository.deleteById(id);
    }
}
