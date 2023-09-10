package com.challenge.hotel.alura.hotelapi.domain.reservation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataRegisterReservation(

    @NotBlank
    String  data_entry,

    @NotBlank
    String  data_out,

    @NotNull
    Long    prece_in_cents,

    @NotBlank
    String  payment_method
) {
    
}
