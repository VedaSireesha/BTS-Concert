package com.btsbooking.btsconcert.repository;

import com.btsbooking.btsconcert.model.Payment;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface PaymentRepository extends CrudRepository<Payment, Long> {

    @Modifying
    @Transactional
    @Query("DELETE FROM Payment p WHERE p.booking.bookingId = :bookingId")
    void deleteByBookingId(Long bookingId);
}
