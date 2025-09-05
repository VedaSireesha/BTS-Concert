package com.btsbooking.btsconcert.controller;

import com.btsbooking.btsconcert.dto.BookingRequest;
import com.btsbooking.btsconcert.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/book")
    public ResponseEntity<String> bookTicket(@ModelAttribute BookingRequest request) {
        try {
            bookingService.bookTicket(request);
            return ResponseEntity.ok("Booking successful!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Booking failed: " + e.getMessage());
        }
    }
}

