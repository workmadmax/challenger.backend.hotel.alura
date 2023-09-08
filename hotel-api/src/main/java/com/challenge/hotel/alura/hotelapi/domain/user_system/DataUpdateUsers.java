package com.challenge.hotel.alura.hotelapi.domain.user_system;

import jakarta.validation.constraints.NotNull;

public record DataUpdateUsers(

    @NotNull
    Long id,
    String name,
    String email
) {
         
}
