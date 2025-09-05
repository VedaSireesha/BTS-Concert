package com.btsbooking.btsconcert.service;

import com.btsbooking.btsconcert.dto.BookingRequest;
import com.btsbooking.btsconcert.model.*;
import com.btsbooking.btsconcert.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private FanRepository fanRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private VipPackageRepository vipPackageRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    public Booking bookTicket(BookingRequest request) throws Exception {
        // Check if fan exists by email
        Optional<Fan> fanOpt = fanRepository.findByEmail(request.getEmail());

        Fan fan = fanOpt.orElseGet(() -> {
            Fan newFan = new Fan();
            newFan.setName(request.getName());
            newFan.setEmail(request.getEmail());
            newFan.setPhoneNumber(request.getPhoneNumber());
            newFan.setFanClubMember("N"); // or "Y" if logic requires
            return fanRepository.save(newFan);
        });

        // Validate ticket
        Optional<Ticket> ticketOpt = ticketRepository.findById(Long.valueOf(request.getTicketId()));
        if (ticketOpt.isEmpty()) throw new Exception("Ticket not found");

        Ticket ticket = ticketOpt.get();
        if (ticket.getAvailableSeats() < request.getSeatsBooked()) {
            throw new Exception("Not enough seats available");
        }

        // Create booking
        Booking booking = new Booking();
        booking.setFan(fan);
        booking.setTicket(ticket);
        booking.setSeatsBooked(request.getSeatsBooked());
        booking.setBookingDate(LocalDate.now());
        booking.setStatus("confirmed");

        // Optional VIP package
        if (request.getVipPackageId() != null) {
            vipPackageRepository.findById(Long.valueOf(request.getVipPackageId()))
                .ifPresent(booking::setVipPackage);
        }

        // Save booking
        Booking savedBooking = bookingRepository.save(booking);

        // Handle payment
     // Optional: Handle payment
        if (request.getPaymentMethod() != null) {
            Payment payment = new Payment();
            payment.setBooking(savedBooking);
            payment.setPaymentMethod(request.getPaymentMethod());
            payment.setAmount(ticket.getPrice()); // Or include VIP package logic
            payment.setPaymentDate(LocalDate.now()); // Add this if not already
            payment.setPaymentStatus("successful");  // ✅ Must match DB constraint
            paymentRepository.save(payment);
        }

        return savedBooking;
    }
}
