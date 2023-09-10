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

import com.challenge.hotel.alura.hotelapi.domain.reservation.DataRegisterReservation;
import com.challenge.hotel.alura.hotelapi.domain.reservation.DataUpdateReserve;
import com.challenge.hotel.alura.hotelapi.domain.reservation.DetailReserve;
import com.challenge.hotel.alura.hotelapi.domain.reservation.Reservations;
import com.challenge.hotel.alura.hotelapi.domain.reservation.ReservationsRepository;
import com.challenge.hotel.alura.hotelapi.domain.user_system.DataListUsers;
import com.challenge.hotel.alura.hotelapi.domain.user_system.DataUpdateUsers;
import com.challenge.hotel.alura.hotelapi.domain.user_system.DetailUser;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/hotel_alura/reservation")
public class ReservationsController {
	
	@Autowired
	private ReservationsRepository reservationRepository;

	@PostMapping
	@Transactional
	public ResponseEntity<DetailReserve> registerUser(@RequestBody @Valid DataRegisterReservation data, UriComponentsBuilder uriBuilder) {
		
		var reserve = new Reservations(data);
		reservationRepository.save(reserve);
		
		var uri = uriBuilder.path("/hotel_alura/reservation/{id}").buildAndExpand(reserve.getId_reserve()).toUri();
		return (ResponseEntity.created(uri).body(new DetailReserve(reserve)));
	}

	@GetMapping
    public ResponseEntity<Page<DetailReserve>> listUsers(Pageable pagination) {
        var page = reservationRepository.findAll(pagination).map(DetailReserve::new);
        return (ResponseEntity.ok(page));

    }

	@PutMapping
    @Transactional
    public ResponseEntity<DetailReserve> toUpdateReserve(@RequestBody @Valid DataUpdateReserve data) {
        
        var reserve = reservationRepository.getReferenceById(data.id_reserve());
        reserve.updateDataReserve(data);
        return (ResponseEntity.ok(new DetailReserve(reserve)));
    }

	@DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> deleteReserve(@PathVariable Long id) {
        var guest = reservationRepository.getReferenceById(id);
        reservationRepository.delete(guest);

        return (ResponseEntity.noContent().build());
    }

}
