package com.btsbooking.btsconcert.model;

import jakarta.persistence.*;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Venue {

    @Id
    private Long venueId;

    private String name;
    private String address;
    private String city;
    private Integer capacity;

    @OneToMany(mappedBy = "venue")
    @JsonIgnore // ✅ Prevent infinite loop during JSON serialization
    private List<Concert> concerts;

    // Getters and Setters
    public Long getVenueId() {
        return venueId;
    }

    public void setVenueId(Long venueId) {
        this.venueId = venueId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public List<Concert> getConcerts() {
        return concerts;
    }

    public void setConcerts(List<Concert> concerts) {
        this.concerts = concerts;
    }
}
