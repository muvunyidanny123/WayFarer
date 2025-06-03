package com.example.WayFarer.controller;

import com.example.WayFarer.entity.Trip;
import com.example.WayFarer.service.TripService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author: Nkurikiyimana Aimable, Iradukunda Joselyne, Mariza Jeanne
 * RegNo: 24582/2024, 21438/2024, 21504/2023
 */
@RestController
@RequestMapping("/api/v1/trips")
public class TripController {

    @Autowired
    private TripService tripService;

    @PostMapping
    public Response createTrip(@RequestBody Trip trip) {
        Trip savedTrip = tripService.createTrip(trip);
        return new Response(201, savedTrip);
    }

    @GetMapping("/{tripId}")
    public Response getTrip(@PathVariable Integer tripId) {
        Trip trip = tripService.getTrip(tripId);
        return new Response(200, trip);
    }

    @GetMapping
    public Response getAllTrips() {
        List<Trip> trips = tripService.getAllTrips();
        return new Response(200, trips);
    }

    @PatchMapping("/{tripId}/cancel")
    public Response cancelTrip(@PathVariable Integer tripId) {
        Trip canceledTrip = tripService.cancelTrip(tripId);
        return new Response(200, canceledTrip);
    }
@Data
    static class Response {
        private int status;
        private Object data;

        public Response(int status, Object data) {
            this.status = status;
            this.data = data;
        }
    }
}
