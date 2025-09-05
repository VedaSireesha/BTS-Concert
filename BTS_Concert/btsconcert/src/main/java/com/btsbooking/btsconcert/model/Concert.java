package com.btsbooking.btsconcert.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Concert {

    @Id
    private Long concertId;

    private String name;
    private String city;
    private LocalDate concertDate;
    private LocalDateTime concertTime;

    @ManyToOne
    @JoinColumn(name = "venue_id")
    private Venue venue;

    @OneToMany(mappedBy = "concert")
    @JsonIgnore // ✅ Prevent recursive loop when fetching tickets
    private List<Ticket> tickets;

    // Getters and Setters
    public Long getConcertId() {
        return concertId;
    }

    public void setConcertId(Long concertId) {
        this.concertId = concertId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDate getConcertDate() {
        return concertDate;
    }

    public void setConcertDate(LocalDate concertDate) {
        this.concertDate = concertDate;
    }

    public LocalDateTime getConcertTime() {
        return concertTime;
    }

    public void setConcertTime(LocalDateTime concertTime) {
        this.concertTime = concertTime;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
