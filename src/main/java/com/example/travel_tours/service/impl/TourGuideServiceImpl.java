package com.example.travel_tours.service.impl;

import com.example.travel_tours.dto.TourGuideDTO;
import com.example.travel_tours.entity.TourGuide;
import com.example.travel_tours.repository.TourGuideRepository;
import com.example.travel_tours.service.TourGuideService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TourGuideServiceImpl implements TourGuideService {

    @Autowired
    private TourGuideRepository tourGuideRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void addTourGuide(TourGuideDTO tourGuideDTO) {
        if (tourGuideRepo.existsById(tourGuideDTO.getGuideID())) {
            throw new RuntimeException("Tour Guide already exists");
        }
        tourGuideRepo.save(modelMapper.map(tourGuideDTO, TourGuide.class));
    }


    @Override
    public List<TourGuideDTO> getAllTourGuides() {
        return modelMapper.map(tourGuideRepo.findAll(),
                new TypeToken<List<TourGuideDTO>>() {}.getType());
    }

    @Override
    public void updateTourGuide(TourGuideDTO tourGuideDTO) {
        if (tourGuideRepo.existsById(tourGuideDTO.getGuideID())) {
            tourGuideRepo.save(modelMapper.map(tourGuideDTO, TourGuide.class));
        } else {
            throw new RuntimeException("Tour Guide does not exist");
        }
    }

    @Override
    public void deleteTourGuide(int id) {
        if (tourGuideRepo.existsById(id)) {
            tourGuideRepo.deleteById(id);
        } else {
            throw new RuntimeException("Tour Guide does not exist");
        }
    }

    @Override
    public TourGuideDTO getTourGuideById(int id) {
        System.out.println("Fetching tour guide with ID: " + id);  // Debugging line
        TourGuide tourGuide = tourGuideRepo.findById(id).orElse(null);
        if (tourGuide == null) {
            throw new EntityNotFoundException("Tour Guide not found with ID: " + id);
        }
        return modelMapper.map(tourGuide, TourGuideDTO.class);
    }


}
