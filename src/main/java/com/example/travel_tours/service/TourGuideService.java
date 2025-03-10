package com.example.travel_tours.service;

import com.example.travel_tours.dto.TourGuideDTO;
import java.util.List;

public interface TourGuideService {
    // Add a new TourGuide
    void addTourGuide(TourGuideDTO tourGuideDTO);

    // Get all TourGuides
    List<TourGuideDTO> getAllTourGuides();

    // Update an existing TourGuide
    void updateTourGuide(TourGuideDTO tourGuideDTO);

    // Delete a TourGuide by ID
    void deleteTourGuide(int id);

    TourGuideDTO getTourGuideById(int id);
}
