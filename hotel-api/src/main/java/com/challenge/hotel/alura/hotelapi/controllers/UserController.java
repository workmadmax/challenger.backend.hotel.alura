package com.challenge.hotel.alura.hotelapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.challenge.hotel.alura.hotelapi.domain.user_system.DataListUsers;
import com.challenge.hotel.alura.hotelapi.domain.user_system.DataRegisterUser;
import com.challenge.hotel.alura.hotelapi.domain.user_system.DataUpdateUsers;
import com.challenge.hotel.alura.hotelapi.domain.user_system.DetailUser;
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
    public ResponseEntity<DetailUser> registerUser(@RequestBody @Valid DataRegisterUser data, UriComponentsBuilder uriBuilder) {
        
        var user = new UserSystem(data);
        userRepository.save(user);
        var uri = uriBuilder.path("/hotel_alura/users_system/{id}").buildAndExpand(user.getId()).toUri();
        return (ResponseEntity.created(uri).body(new DetailUser(user)));
    }

    @GetMapping
    public ResponseEntity<Page<DataListUsers>> listUsers(Pageable pagination) {
        var page = userRepository.findAllByActiveTrue(pagination).map(DataListUsers::new);
        return (ResponseEntity.ok(page));

    }
    
    @PutMapping
    @Transactional
    public ResponseEntity<DetailUser> toUpdate(@RequestBody @Valid DataUpdateUsers data) {
        
        var user = userRepository.getReferenceById(data.id());
        user.updateData(data);
        return (ResponseEntity.ok(new DetailUser(user)));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        var user = userRepository.getReferenceById(id);
        user.setActive(false);

        return (ResponseEntity.noContent().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailUser> showUserDetails(@PathVariable Long id) {
        var user = userRepository.getReferenceById(id);
        return (ResponseEntity.ok(new DetailUser(user)));
    }
}
