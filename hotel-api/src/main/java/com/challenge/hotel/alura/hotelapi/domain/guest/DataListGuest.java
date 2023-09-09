package com.challenge.hotel.alura.hotelapi.domain.guest;

public record DataListGuest(Long id, String name, String last_name) {

    public DataListGuest(Guests guest) {
        this(guest.getId(), guest.getName(), guest.getLast_name());
    }
    
}
