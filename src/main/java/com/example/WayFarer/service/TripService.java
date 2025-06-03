package com.example.WayFarer.service;

import com.example.WayFarer.entity.Trip;
import com.example.WayFarer.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: Nkurikiyimana Aimable, Iradukunda Joselyne, Mariza Jeanne
 * RegNo: 24582/2024, 21438/2024, 21504/2023
 */
@Service
public class TripService {

    @Autowired
    private TripRepository tripRepository;

    public Trip createTrip(Trip trip) {
        return tripRepository.save(trip);
    }

    public Trip getTrip(Integer tripId) {
        return tripRepository.findById(tripId)
                .orElseThrow(() -> new RuntimeException("Trip not found with ID: " + tripId));
    }

    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    public Trip cancelTrip(Integer tripId) {
        Trip trip = getTrip(tripId);
        trip.setStatus("cancelled");
        return tripRepository.save(trip);
    }
}
