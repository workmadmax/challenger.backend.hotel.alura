package com.challenge.hotel.alura.hotelapi.domain.reservation;

public record DataUpdateReserve(

        Long id_reserve,

        String data_entry,

        String data_out,

        Long prece_in_cents,

        Long id_guest,

        String payment_method
) {
    
}
