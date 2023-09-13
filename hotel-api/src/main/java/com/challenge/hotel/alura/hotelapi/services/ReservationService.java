package com.challenge.hotel.alura.hotelapi.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.challenge.hotel.alura.hotelapi.domain.reservation.DataRegisterReservation;
import com.challenge.hotel.alura.hotelapi.domain.reservation.DataUpdateReserve;
import com.challenge.hotel.alura.hotelapi.domain.reservation.DetailReserve;
import com.challenge.hotel.alura.hotelapi.domain.reservation.Reservations;
import com.challenge.hotel.alura.hotelapi.domain.reservation.ReservationsRepository;

@Service
public class ReservationService {

    private final ReservationsRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationsRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservations registerReservation(DataRegisterReservation data) {
        Reservations reservation = new Reservations(data);
        return reservationRepository.save(reservation);
    }

    public Page<DetailReserve> listReservations(Pageable pagination) {
        Page<Reservations> reservationPage = reservationRepository.findAll(pagination);
        return reservationPage.map(DetailReserve::new);
    }

    public Reservations updateReservation(DataUpdateReserve data) {
        Reservations reservation = reservationRepository.getReferenceById(data.id_reserve());
        reservation.updateDataReserve(data);
        return reservation;
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }

    public Reservations getReservationById(Long id) {
        return reservationRepository.findById(id).orElse(null);
    }
}
