package com.challenge.hotel.alura.hotelapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.hotel.alura.hotelapi.domain.user_system.DataListUsers;
import com.challenge.hotel.alura.hotelapi.domain.user_system.DataRegisterUser;
import com.challenge.hotel.alura.hotelapi.domain.user_system.UserRepository;
import com.challenge.hotel.alura.hotelapi.domain.user_system.UserSystem;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/hotel_alura/users_system")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    

    @PostMapping
    @Transactional
    public void registerUser(@RequestBody @Valid DataRegisterUser data) {
        
        userRepository.save(new UserSystem(data));
    }

    @GetMapping
    public Page<DataListUsers> listUsers(Pageable pagination) {
        return userRepository.findAll(pagination).map(DataListUsers::new);
    }
    
}
