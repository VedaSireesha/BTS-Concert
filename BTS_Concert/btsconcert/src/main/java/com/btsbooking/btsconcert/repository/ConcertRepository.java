package com.btsbooking.btsconcert.repository;

import com.btsbooking.btsconcert.model.Concert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConcertRepository extends JpaRepository<Concert, Long> {
}
