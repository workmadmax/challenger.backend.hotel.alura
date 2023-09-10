package com.challenge.hotel.alura.hotelapi.domain.reservation;

public record DetailReserve(

    Long    id_reserve,
    String  data_entry,
    String  data_out,
    Long    prece_in_cents

) {

    public DetailReserve(Reservations reserve) {
        this(reserve.getId_reserve(), reserve.getData_entry(), reserve.getData_out(), reserve.getPrece_in_cents());
    }
    
}
