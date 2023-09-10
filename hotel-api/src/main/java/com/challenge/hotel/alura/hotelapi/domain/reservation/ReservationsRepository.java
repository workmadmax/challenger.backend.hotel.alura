package com.challenge.hotel.alura.hotelapi.domain.reservation;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationsRepository extends JpaRepository<Reservations, Long> {
    
}
