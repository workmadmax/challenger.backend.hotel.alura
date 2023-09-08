package com.challenge.hotel.alura.hotelapi.domain.user_system;

public record DetailUser(Long id, String name, String email, String login, String password, Boolean active) {

    public DetailUser(UserSystem user) {
        this(user.getId(), user.getName(), user.getEmail(), user.getLogin(), user.getPassword(), user.getActive());
    }
    
}
