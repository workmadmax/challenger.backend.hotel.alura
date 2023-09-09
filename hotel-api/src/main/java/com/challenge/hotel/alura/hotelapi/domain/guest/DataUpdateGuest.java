package com.challenge.hotel.alura.hotelapi.domain.guest;


import jakarta.validation.constraints.NotNull;

public record DataUpdateGuest(

        @NotNull
        Long id,

        String name,

        String last_name,

        String date_of_birth,

        String nationality,

        String phone,

        @NotNull
        Long id_reservation) {

}