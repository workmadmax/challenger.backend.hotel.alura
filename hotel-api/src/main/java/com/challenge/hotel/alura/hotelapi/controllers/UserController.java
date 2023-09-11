package com.challenge.hotel.alura.hotelapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import com.challenge.hotel.alura.hotelapi.domain.user_system.DataListUsers;
import com.challenge.hotel.alura.hotelapi.domain.user_system.DataRegisterUser;
import com.challenge.hotel.alura.hotelapi.domain.user_system.DataUpdateUsers;
import com.challenge.hotel.alura.hotelapi.domain.user_system.DetailUser;
import com.challenge.hotel.alura.hotelapi.domain.user_system.UserSystem;
import com.challenge.hotel.alura.hotelapi.services.UserService;

import jakarta.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping("/hotel_alura/users_system")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DetailUser> registerUser(@RequestBody @Valid DataRegisterUser data, UriComponentsBuilder uriBuilder) {
        UserSystem user = userService.registerUser(data);
        var uri = uriBuilder.path("/hotel_alura/users_system/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetailUser(user));
    }

    @GetMapping
    public ResponseEntity<Page<DataListUsers>> listUsers(Pageable pagination) {
        Page<DataListUsers> page = userService.listUsers(pagination);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DetailUser> toUpdate(@RequestBody @Valid DataUpdateUsers data) {
        UserSystem user = userService.updateUser(data);
        return ResponseEntity.ok(new DetailUser(user));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailUser> showUserDetails(@PathVariable Long id) {
        UserSystem user = userService.getUserById(id);
        return ResponseEntity.ok(new DetailUser(user));
    }
}
