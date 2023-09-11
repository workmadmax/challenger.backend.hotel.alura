package com.challenge.hotel.alura.hotelapi.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.challenge.hotel.alura.hotelapi.domain.user_system.DataListUsers;
import com.challenge.hotel.alura.hotelapi.domain.user_system.DataRegisterUser;
import com.challenge.hotel.alura.hotelapi.domain.user_system.DataUpdateUsers;
import com.challenge.hotel.alura.hotelapi.domain.user_system.UserRepository;
import com.challenge.hotel.alura.hotelapi.domain.user_system.UserSystem;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserSystem registerUser(DataRegisterUser data) {
        UserSystem user = new UserSystem(data);
        return userRepository.save(user);
    }

    public Page<DataListUsers> listUsers(Pageable pagination) {
        Page<UserSystem> userPage = userRepository.findAllByActiveTrue(pagination);
        return userPage.map(DataListUsers::new);
    }

    public UserSystem updateUser(DataUpdateUsers data) {
        UserSystem user = userRepository.getReferenceById(data.id());
        user.updateData(data);
        return user;
    }

    public void deleteUser(Long id) {
        UserSystem user = userRepository.getReferenceById(id);
        user.setActive(false);
    }

    public UserSystem getUserById(Long id) {
        return userRepository.getReferenceById(id);
    }
}
