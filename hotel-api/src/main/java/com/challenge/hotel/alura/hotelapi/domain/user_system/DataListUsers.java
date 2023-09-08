package com.challenge.hotel.alura.hotelapi.domain.user_system;

public record DataListUsers(String name, String email) {
    
    public DataListUsers(UserSystem user) {
        this(user.getName(), user.getEmail());
    }
}
