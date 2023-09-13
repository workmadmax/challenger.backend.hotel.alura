package com.challenge.hotel.alura.hotelapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.challenge.hotel.alura.hotelapi.domain.guest.DataListGuest;
import com.challenge.hotel.alura.hotelapi.domain.guest.DataRegisterGuest;
import com.challenge.hotel.alura.hotelapi.domain.guest.DataUpdateGuest;
import com.challenge.hotel.alura.hotelapi.domain.guest.GuestRepository;
import com.challenge.hotel.alura.hotelapi.domain.guest.Guests;

@Service
public class GuestService {

    private final GuestRepository guestRepository;

    @Autowired
    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public Guests registerGuest(DataRegisterGuest data) {
        Guests guest = new Guests(data);
        return guestRepository.save(guest);
    }

    public Page<DataListGuest> listGuests(Pageable pagination) {
        Page<Guests> guestPage = guestRepository.findAll(pagination);
        return guestPage.map(DataListGuest::new);
    }

    public Guests updateGuest(DataUpdateGuest data) {
        Guests guest = guestRepository.getReferenceById(data.id());
        guest.updateGuest(data);
        return guest;
    }

    public void deleteGuest(Long id) {
        guestRepository.deleteById(id);
    }
}
