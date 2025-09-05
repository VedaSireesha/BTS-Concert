package com.btsbooking.btsconcert.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "booking_seq")
    @SequenceGenerator(name = "booking_seq", sequenceName = "BOOKING_SEQ", allocationSize = 1)
    @Column(name = "booking_id")
    private Long bookingId;

    @ManyToOne
    @JoinColumn(name = "fan_id", nullable = false)
    private Fan fan;

    @ManyToOne
    @JoinColumn(name = "ticket_id", nullable = false)
    private Ticket ticket;

    @ManyToOne
    @JoinColumn(name = "vip_package_id")
    private VipPackage vipPackage;

    @Column(name = "seats_booked", nullable = false)
    private int seatsBooked;

    @Column(name = "booking_date", nullable = false)
    private LocalDate bookingDate;

    @Column(name = "status", nullable = false)
    private String status;

    // Getters and Setters
    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Fan getFan() {
        return fan;
    }

    public void setFan(Fan fan) {
        this.fan = fan;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public VipPackage getVipPackage() {
        return vipPackage;
    }

    public void setVipPackage(VipPackage vipPackage) {
        this.vipPackage = vipPackage;
    }

    public int getSeatsBooked() {
        return seatsBooked;
    }

    public void setSeatsBooked(int seatsBooked) {
        this.seatsBooked = seatsBooked;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
