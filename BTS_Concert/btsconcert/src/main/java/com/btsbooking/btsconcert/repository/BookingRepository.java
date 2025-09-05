package com.btsbooking.btsconcert.repository;

import com.btsbooking.btsconcert.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    // Custom method to find bookings by fan ID
    List<Booking> findByFan_FanId(Long fanId);
}
