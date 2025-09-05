package com.btsbooking.btsconcert.model;

import jakarta.persistence.*;

@Entity
@Table(name = "fan")
public class Fan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Oracle auto-generates FAN_ID
    @Column(name = "fan_id")
    private Long fanId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "fan_club_member", nullable = false)
    private String fanClubMember;

    // Getters
    public Long getFanId() {
        return fanId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getFanClubMember() {
        return fanClubMember;
    }

    // Setters (NO setter for fanId!)
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setFanClubMember(String fanClubMember) {
        this.fanClubMember = fanClubMember;
    }
}

