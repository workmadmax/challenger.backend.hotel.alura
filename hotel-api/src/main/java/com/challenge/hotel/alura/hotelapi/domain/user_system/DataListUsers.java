package com.challenge.hotel.alura.hotelapi.domain.user_system;

public record DataListUsers(Long id, String name, String email) {
    
    public DataListUsers(UserSystem user) {
        this(user.getId(), user.getName(), user.getEmail());
    }
}
