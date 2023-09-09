package com.challenge.hotel.alura.hotelapi.domain.guest;

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
@Table(name = "guests")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Guests {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long    id;
    private String  name;
    private String  last_name;
    private String  date_of_birth;
    private String  nationality;
    private String  phone;
    private Long    id_reservation;

    public Guests(DataRegisterGuest data) {
		this.name = data.name();
        this.last_name = data.last_name();
        this.date_of_birth = data.date_of_birth();
        this.nationality = data.nationality();
        this.phone = data.phone();
        this.id_reservation = data.id_reservation();
	}

    public void updateGuest(@Valid DataUpdateGuest data) {
        
        if (data.name() != null) {
            this.name = data.name();
        }
        if (data.last_name() != null) {
            this.last_name = data.last_name();
        }
        if (data.date_of_birth() != null) {
            this.date_of_birth = data.date_of_birth();
        }
        if (data.nationality() != null) {
            this.nationality = data.nationality();
        }
        if (data.phone() != null) {
            this.phone = data.phone();
        }
        if (data.id_reservation() != null) {
            this.id_reservation = data.id_reservation();
        }
    }
}
