package com.example.JobTrackerApp.controller;

import com.example.JobTrackerApp.entity.JobApplication;
import com.example.JobTrackerApp.service.JobApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/jobs")
@CrossOrigin // Enables CORS
public class JobApplicationController {
    @Autowired
    private JobApplicationService service;

    @GetMapping
    public List<JobApplication> getAllApplications() {
        return service.getAllApplications();
    }

    @GetMapping("/{id}")
    public Optional<JobApplication> getApplicationById(@PathVariable Long id) {
        return service.getApplicationById(id);
    }

    @PostMapping
    public JobApplication saveApplication(@RequestBody JobApplication application) {
        return service.saveApplication(application);
    }

    @PutMapping("/{id}")
    public JobApplication updateApplication(@PathVariable Long id, @RequestBody JobApplication application) {
        application.setId(id);
        return service.saveApplication(application);
    }

    @DeleteMapping("/{id}")
    public void deleteApplication(@PathVariable Long id) {
        service.deleteApplication(id);
    }
}

