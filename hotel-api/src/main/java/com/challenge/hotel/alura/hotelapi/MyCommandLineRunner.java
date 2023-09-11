package com.challenge.hotel.alura.hotelapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.challenge.hotel.alura.hotelapi.resources.views.Login;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        // Inicie a janela Login aqui
        Login login = new Login();
        login.setVisible(true);
    }
}
