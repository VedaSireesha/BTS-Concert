package com.btsbooking.btsconcert.repository;

import com.btsbooking.btsconcert.model.Fan;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface FanRepository extends JpaRepository<Fan, Long> {
    Optional<Fan> findByEmail(String email); // <-- Add this line
}
