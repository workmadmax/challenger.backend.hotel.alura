package com.challenge.hotel.alura.hotelapi.domain.user_system;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserSystem, Long>{

    Page<UserSystem> findAllByActiveTrue(Pageable pagination);
    UserSystem findByLogin(String login);
    
}
