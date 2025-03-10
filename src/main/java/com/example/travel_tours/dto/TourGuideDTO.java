package com.example.travel_tours.dto;

import java.time.LocalDateTime;

public class TourGuideDTO {
    private int guideID;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String experience;
    private String languagesSpoken;
    private LocalDateTime createdAt;

    // Default Constructor
    public TourGuideDTO() {
    }

    // Constructor with parameters
    public TourGuideDTO(int guideID, String fullName, String email, String phoneNumber, String experience, String languagesSpoken, LocalDateTime createdAt) {
        this.guideID = guideID;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.experience = experience;
        this.languagesSpoken = languagesSpoken;
        this.createdAt = createdAt;
    }

    // Getters and Setters
    public int getGuideID() {
        return guideID;
    }

    public void setGuideID(int guideID) {
        this.guideID = guideID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getLanguagesSpoken() {
        return languagesSpoken;
    }

    public void setLanguagesSpoken(String languagesSpoken) {
        this.languagesSpoken = languagesSpoken;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "TourGuideDTO{" +
                "guideID=" + guideID +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", experience='" + experience + '\'' +
                ", languagesSpoken='" + languagesSpoken + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
