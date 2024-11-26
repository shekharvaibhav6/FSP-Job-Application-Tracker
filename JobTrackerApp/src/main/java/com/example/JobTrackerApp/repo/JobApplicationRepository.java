package com.example.JobTrackerApp.repo;



import com.example.JobTrackerApp.entity.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {
}
