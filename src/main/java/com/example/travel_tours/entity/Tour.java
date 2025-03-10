//package com.example.travel_tours.entity;
//
//import jakarta.persistence.*;
//
//import java.util.Date;
//
//@Entity
//@Table(name = "Tours")
//public class Tour {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "TourID")
//    private int tourID;
//
//    @Column(name = "TourName", nullable = false, length = 255)
//    private String tourName;
//
//    @Column(name = "Description", columnDefinition = "TEXT")
//    private String description;
//
//    @Column(name = "Location", nullable = false, length = 255)
//    private String location;
//
//    @Column(name = "Duration", nullable = false)
//    private int duration;
//
//    @Column(name = "Price", nullable = false, precision = 10, scale = 2)
//    private double price;
//
//    @Enumerated(EnumType.STRING)
//    @Column(name = "TourType", nullable = false)
//    private TourType tourType;
//
//    @Column(name = "AvailableSeats", nullable = false)
//    private int availableSeats;
//
//    @Column(name = "StartDate", nullable = false)
//    @Temporal(TemporalType.DATE)
//    private Date startDate;
//
//    @Column(name = "EndDate", nullable = false)
//    @Temporal(TemporalType.DATE)
//    private Date endDate;
//
//    @ManyToOne
//    @JoinColumn(name = "TourOperatorID")
//    private User tourOperator;
//
//    @Column(name = "Images", length = 255)
//    private String images;
//
//    @Column(name = "CreatedAt", updatable = false)
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date createdAt;
//
//    // Constructors, getters, setters, and other methods
//
//    public Tour() {
//    }
//
//    // Getters and setters for all fields
//
//    public int getTourID() {
//        return tourID;
//    }
//
//    public void setTourID(int tourID) {
//        this.tourID = tourID;
//    }
//
//    public String getTourName() {
//        return tourName;
//    }
//
//    public void setTourName(String tourName) {
//        this.tourName = tourName;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getLocation() {
//        return location;
//    }
//
//    public void setLocation(String location) {
//        this.location = location;
//    }
//
//    public int getDuration() {
//        return duration;
//    }
//
//    public void setDuration(int duration) {
//        this.duration = duration;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }
//
//    public TourType getTourType() {
//        return tourType;
//    }
//
//    public void setTourType(TourType tourType) {
//        this.tourType = tourType;
//    }
//
//    public int getAvailableSeats() {
//        return availableSeats;
//    }
//
//    public void setAvailableSeats(int availableSeats) {
//        this.availableSeats = availableSeats;
//    }
//
//    public Date getStartDate() {
//        return startDate;
//    }
//
//    public void setStartDate(Date startDate) {
//        this.startDate = startDate;
//    }
//
//    public Date getEndDate() {
//        return endDate;
//    }
//
//    public void setEndDate(Date endDate) {
//        this.endDate = endDate;
//    }
//
//    public User getTourOperator() {
//        return tourOperator;
//    }
//
//    public void setTourOperator(User tourOperator) {
//        this.tourOperator = tourOperator;
//    }
//
//    public String getImages() {
//        return images;
//    }
//
//    public void setImages(String images) {
//        this.images = images;
//    }
//
//    public Date getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(Date createdAt) {
//        this.createdAt = createdAt;
//    }
//}
