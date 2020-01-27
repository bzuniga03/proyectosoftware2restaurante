package com.restaurante.proyecto;

import com.restaurante.proyecto.models.dao.CategoriaRepository;
import com.restaurante.proyecto.models.dao.GreetingRepository;
import com.restaurante.proyecto.models.dao.PlatoRepository;
import com.restaurante.proyecto.models.entity.Categoria;
import com.restaurante.proyecto.models.entity.Greeting;
import com.restaurante.proyecto.models.entity.Plato;
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
            greetingRepository.save(new Greeting("Hola", 2.3));
            greetingRepository.save(new Greeting("Hi", 1.5));
/*
            Categoria categoria = new Categoria("Plato Fuerte");
            Categoria categoria2 = new Categoria("Sopas");
            Categoria categoria3 = new Categoria("Entradas");

            platoRepository.save(new Plato("Churrasco", 5d, categoria));
            platoRepository.save(new Plato("Sopa de pollo", 1.3, categoria2));
            platoRepository.save(new Plato("Queso", 8d, categoria3));

 */
        };

    }
}
