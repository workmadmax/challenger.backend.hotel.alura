package com.challenge.hotel.alura.hotelapi.domain.user_system;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


public record DataRegisterUser(

    @NotBlank
    String name,

    @NotBlank
    @Email
    String email,

    @NotBlank
    String login,

    @NotBlank
    String password) {
    
}
