package com.restaurante.proyecto;

import com.restaurante.proyecto.models.dao.GreetingRepository;
import com.restaurante.proyecto.models.entity.Greeting;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class Proyectosoftware2Application {

    public static void main(String[] args) {
        SpringApplication.run(Proyectosoftware2Application.class, args);
    }

    @Bean
    ApplicationRunner applicationRunner(GreetingRepository greetingRepository) {
        return args -> {
            greetingRepository.save(new Greeting("Hola"));
            greetingRepository.save(new Greeting("Hi"));
        };

    }
}
