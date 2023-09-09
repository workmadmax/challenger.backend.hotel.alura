package com.challenge.hotel.alura.hotelapi.domain.guest;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guests, Long> {
    
}
