package com.btsbooking.btsconcert.dto;

public class BookingRequest {
    private String name;
    private String email;
    private String phoneNumber;
    private int ticketId;
    private int seatsBooked;
    private Integer vipPackageId; // Optional
    private String paymentMethod;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getSeatsBooked() {
        return seatsBooked;
    }

    public void setSeatsBooked(int seatsBooked) {
        this.seatsBooked = seatsBooked;
    }

    public Integer getVipPackageId() {
        return vipPackageId;
    }

    public void setVipPackageId(Integer vipPackageId) {
        this.vipPackageId = vipPackageId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
