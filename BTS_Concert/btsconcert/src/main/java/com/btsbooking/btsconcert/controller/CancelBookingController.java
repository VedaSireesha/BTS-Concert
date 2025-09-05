package com.btsbooking.btsconcert.controller;

import com.btsbooking.btsconcert.model.Booking;
import com.btsbooking.btsconcert.repository.BookingRepository;
import com.btsbooking.btsconcert.repository.FanRepository;
import com.btsbooking.btsconcert.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CancelBookingController {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private FanRepository fanRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @PostMapping("/cancel-booking")
    @ResponseBody
    public String cancelBooking(@RequestParam("bookingId") Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId).orElse(null);

        if (booking == null) {
            return "❌ Booking ID not found.";
        }

        Long fanId = booking.getFan().getFanId();

        // Step 1: Delete payment(s) first (to avoid FK constraint error)
        paymentRepository.deleteByBookingId(bookingId);

        // Step 2: Delete booking
        bookingRepository.deleteById(bookingId);

        // Step 3: Delete fan only if no other bookings exist
        List<Booking> fanBookings = bookingRepository.findByFan_FanId(fanId);
        if (fanBookings.isEmpty()) {
            fanRepository.deleteById(fanId);
        }

        return "✅ Booking and related records successfully canceled.";
    }
}
