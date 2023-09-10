package com.challenge.hotel.alura.hotelapi.domain.reservation;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "reservation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_reserve")
public class Reservations {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long    id_reserve;
    private String  data_entry;
    private String  data_out;
    private Long    prece_in_cents;
    private String  payment_method;
    

    public Reservations(DataRegisterReservation data) {
        this.data_entry = data.data_entry();
        this.data_out = data.data_out();
        this.prece_in_cents = data.prece_in_cents();
        this.payment_method = data.payment_method();
    }


    public void updateDataReserve(@Valid DataUpdateReserve data) {
        if (data.data_entry() != null) {
            this.data_entry = data.data_entry();
        }
        if (data.data_out() != null) {
            this.data_out = data.data_out();
        }
        if (data.prece_in_cents() != null) {
            this.prece_in_cents = data.prece_in_cents();
        }
        if (data.payment_method() != null) {
            this.payment_method = data.payment_method();
        }
    }

}
