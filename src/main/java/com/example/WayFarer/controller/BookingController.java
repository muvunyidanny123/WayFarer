package com.example.WayFarer.controller;

import com.example.WayFarer.entity.Booking;
import com.example.WayFarer.service.BookingService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author: Nkurikiyimana Aimable, Iradukunda Joselyne, Mariza Jeanne
 * RegNo: 24582/2024, 21438/2024, 21504/2023
 */
@RestController
@RequestMapping("/api/v1/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public Response bookTrip(@RequestBody Booking booking) {
        Booking savedBooking = bookingService.bookTrip(booking);
        return new Response(201, savedBooking);
    }

    @GetMapping
    public Response getAllBookings() {
        List<Booking> bookings = bookingService.getAllBookings();
        return new Response(200, bookings);
    }

    @DeleteMapping("/{bookingId}")
    public Response deleteBooking(@PathVariable Integer bookingId) {
        bookingService.deleteBooking(bookingId);
        return new Response(200, "Booking deleted successfully");
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
