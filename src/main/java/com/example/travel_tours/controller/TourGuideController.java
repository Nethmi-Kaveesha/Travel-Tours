package com.example.travel_tours.controller;

import com.example.travel_tours.dto.TourGuideDTO;
import com.example.travel_tours.service.impl.TourGuideServiceImpl;
import com.example.travel_tours.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tour-guides")
@CrossOrigin(origins = "http://localhost:63342")  // This allows all origins, for development purposes.
public class TourGuideController {

    @Autowired
    private TourGuideServiceImpl tourGuideService;

    // Save a new TourGuide
    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveTourGuide(@RequestBody TourGuideDTO tourGuideDTO) {
        try {
            tourGuideService.addTourGuide(tourGuideDTO);
            return new ResponseUtil(201, "Tour Guide Saved", tourGuideDTO);
        } catch (Exception e) {
            return new ResponseUtil(500, "Error Saving Tour Guide", e.getMessage());
        }
    }


    // Get all TourGuides
    @GetMapping("getAll")
    public List<TourGuideDTO> getAllTourGuides() {
        return tourGuideService.getAllTourGuides();
    }

    // Update an existing TourGuide
    @PutMapping(value = "update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateTourGuide(@RequestBody TourGuideDTO tourGuideDTO) {
        tourGuideService.updateTourGuide(tourGuideDTO);
        return new ResponseUtil(200, "Tour Guide Updated", null);
    }

    // Get a specific TourGuide by ID
    @GetMapping("get/{guideID}")
    public ResponseUtil getTourGuideById(@PathVariable("guideID") String id) {
        try {
            TourGuideDTO tourGuideDTO = tourGuideService.getTourGuideById(Integer.parseInt(id));
            if (tourGuideDTO != null) {
                return new ResponseUtil(200, "Tour Guide Found", tourGuideDTO);
            } else {
                return new ResponseUtil(404, "Tour Guide Not Found", null);
            }
        } catch (Exception e) {
            return new ResponseUtil(500, "Error Fetching Tour Guide", e.getMessage());
        }
    }


    // Delete a TourGuide
    @DeleteMapping("delete/{id}")
    public ResponseUtil deleteTourGuide(@PathVariable("id") String id) {
        tourGuideService.deleteTourGuide(Integer.parseInt(id));
        return new ResponseUtil(200, "Tour Guide Deleted", null);
    }
}
