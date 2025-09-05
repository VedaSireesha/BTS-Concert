package com.btsbooking.btsconcert.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_seq")
    @SequenceGenerator(name = "ticket_seq", sequenceName = "TICKET_SEQ", allocationSize = 1)
    @Column(name = "ticket_id")
    private Long ticketId;

    @Column(name = "ticket_type", nullable = false)
    private String ticketType;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "available_seats", nullable = false)
    private int availableSeats;

    // Relationships
    @ManyToOne
    @JoinColumn(name = "concert_id", nullable = false)
    private Concert concert;

    // Getters and Setters
    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public Concert getConcert() {
        return concert;
    }

    public void setConcert(Concert concert) {
        this.concert = concert;
    }
}
