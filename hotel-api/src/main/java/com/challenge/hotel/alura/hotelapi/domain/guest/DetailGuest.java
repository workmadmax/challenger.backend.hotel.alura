package com.challenge.hotel.alura.hotelapi.domain.guest;



public record DetailGuest(
        Long id,
        String name,
        String last_name,
        String date_of_birth,
        String nationality,
        String phone,
        Long id_reservation) {

    public DetailGuest(Guests guest) {
        this(guest.getId(), guest.getName(), guest.getLast_name(), guest.getDate_of_birth(),
                guest.getNationality(), guest.getPhone(), guest.getId_reservation());
    }

}