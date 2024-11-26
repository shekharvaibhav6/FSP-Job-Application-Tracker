package com.example.JobTrackerApp.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class JobApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;
    private String role;
    private LocalDate applicationDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Lob
    private String notes;

    // Getters and setters
    public enum Status {
        APPLIED,
        INTERVIEWING,
        OFFERED,
        REJECTED
    }
    public JobApplication(){

    }

    public JobApplication(Long id, String companyName, String role, LocalDate applicationDate, Status status, String notes) {
        this.id = id;
        this.companyName = companyName;
        this.role = role;
        this.applicationDate = applicationDate;
        this.status = status;
        this.notes = notes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDate getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(LocalDate applicationDate) {
        this.applicationDate = applicationDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
    // Getters and Setters
}
