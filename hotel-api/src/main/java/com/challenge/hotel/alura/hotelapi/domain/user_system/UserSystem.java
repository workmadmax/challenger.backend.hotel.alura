package com.challenge.hotel.alura.hotelapi.domain.user_system;

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
@Table(name = "users_system")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class UserSystem {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long	id;
	private String	name;
	private String	email;
	private String	login;
	private String	password;
	private Boolean active;
	
	public UserSystem(DataRegisterUser data) {
		this.active = true;
		this.name = data.name();
		this.email = data.email();
		this.login = data.login();
		this.password = data.password();
	}

    public void updateData(@Valid DataUpdateUsers data) {
			
		if (data.name() != null) {
			this.name = data.name();
		}
		if (data.email() != null) {
			this.email = data.email();
		}
	}

	public Boolean checkPassword(String password) {
		return this.password.equals(password);
	}
}
