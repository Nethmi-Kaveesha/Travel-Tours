package com.example.travel_tours.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tour_guides")  // Table name in lowercase with an underscore
public class TourGuide {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "GuideID")
    private int guideID;

    //@Column(name = "FullName", nullable = false, length = 255)
    private String fullName;

    //@Column(name = "Email", nullable = false, unique = true, length = 255)
    private String email;


    //@Column(name = "PhoneNumber", length = 20)
    private String phoneNumber;

    //@Column(name = "Experience", length = 255)
    private String experience;

    //@Column(name = "LanguagesSpoken", columnDefinition = "TEXT")  // Uncommented and fixed column name
    private String languagesSpoken;

    //@Column(name = "CreatedAt", updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")  // Uncommented and fixed column definition
    private LocalDateTime createdAt;

    // Default constructor
    public TourGuide() {
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

    // Optional: You can use a @PrePersist to set 'createdAt' automatically if it's not handled by the database default
    @PrePersist
    public void prePersist() {
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
    }

    @Override
    public String toString() {
        return "TourGuide{" +
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
