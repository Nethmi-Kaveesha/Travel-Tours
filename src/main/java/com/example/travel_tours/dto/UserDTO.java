package com.example.travel_tours.dto;

import com.example.travel_tours.entity.Role;

import java.util.Date;

public class UserDTO {

    private int userID;
    private String fullName;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;
    private Role role;
    private String profilePicture;
    private Date createdAt;
    private Date updatedAt;

    // Constructors, getters, setters

    public UserDTO() {
    }

    public UserDTO(int userID, String fullName, String email, String password, String phoneNumber,
                   String address, Role role, String profilePicture, Date createdAt, Date updatedAt) {
        this.userID = userID;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.role = role;
        this.profilePicture = profilePicture;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
