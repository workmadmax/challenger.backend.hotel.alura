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

import com.challenge.hotel.alura.hotelapi.domain.guest.DataListGuest;
import com.challenge.hotel.alura.hotelapi.domain.guest.DataRegisterGuest;
import com.challenge.hotel.alura.hotelapi.domain.guest.DataUpdateGuest;
import com.challenge.hotel.alura.hotelapi.domain.guest.DetailGuest;
import com.challenge.hotel.alura.hotelapi.domain.guest.GuestRepository;
import com.challenge.hotel.alura.hotelapi.domain.guest.Guests;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/hotel_alura/guests")
public class GuestController {

    @Autowired
    private GuestRepository guestRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DetailGuest> registerGuest(@RequestBody @Valid DataRegisterGuest data, UriComponentsBuilder uriBuilder) {
        
        var guest = new Guests(data);
        guestRepository.save(guest);
        var uri = uriBuilder.path("/hotel_alura/guests/{id}").buildAndExpand(guest.getId()).toUri();

        return (ResponseEntity.created(uri).body(new DetailGuest(guest)));
    }

    @GetMapping
    public ResponseEntity<Page<DataListGuest>> listGuest(Pageable pagination) {
        var page = guestRepository.findAll(pagination).map(DataListGuest::new);
        return (ResponseEntity.ok(page));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DetailGuest> toUpdateGuest(@RequestBody @Valid DataUpdateGuest data) {
        
        var guest = guestRepository.getReferenceById(data.id());
        guest.updateGuest(data);
        return (ResponseEntity.ok(new DetailGuest(guest)));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> deleteGuest(@PathVariable Long id) {
        var guest = guestRepository.getReferenceById(id);
        guestRepository.delete(guest);

        return (ResponseEntity.noContent().build());
    }
}
