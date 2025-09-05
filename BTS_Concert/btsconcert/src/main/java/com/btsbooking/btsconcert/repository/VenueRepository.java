package com.btsbooking.btsconcert.repository;

import com.btsbooking.btsconcert.model.Venue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VenueRepository extends JpaRepository<Venue, Long> {
}
