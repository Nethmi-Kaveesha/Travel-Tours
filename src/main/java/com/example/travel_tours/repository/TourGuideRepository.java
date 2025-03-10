package com.example.travel_tours.repository;

import com.example.travel_tours.entity.TourGuide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface TourGuideRepository extends JpaRepository<TourGuide, Integer> {

    Optional<TourGuide> findByEmail(String email);

    Optional<TourGuide> findByPhoneNumber(String phoneNumber);

    List<TourGuide> findByExperienceContaining(String experience);

    boolean existsByEmail(String email);

    Optional<TourGuide> findByGuideID(int guideID);
}
