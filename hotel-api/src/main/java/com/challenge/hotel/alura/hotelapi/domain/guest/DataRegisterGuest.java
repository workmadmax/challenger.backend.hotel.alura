package com.challenge.hotel.alura.hotelapi.domain.guest;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataRegisterGuest(

    @NotBlank
    String name,

    @NotBlank
    String last_name,

    @NotBlank
    String date_of_birth,

    @NotBlank
    String nationality,

    @NotBlank
    String phone,

    @NotNull
    Long id_reservation
) {

}