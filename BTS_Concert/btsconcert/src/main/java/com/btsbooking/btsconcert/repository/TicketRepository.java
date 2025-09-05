package com.btsbooking.btsconcert.repository;

import com.btsbooking.btsconcert.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
