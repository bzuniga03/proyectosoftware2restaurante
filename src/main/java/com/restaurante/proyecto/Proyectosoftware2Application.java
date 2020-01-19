package com.restaurante.proyecto;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;
import java.util.List;

@SpringBootApplication
public class Proyectosoftware2Application {

    public static void main(String[] args) {
        SpringApplication.run(Proyectosoftware2Application.class, args);
    }

    @Bean
    ApplicationRunner applicationRunner(Greeting.GreetingRepository greetingRepository) {
        return args -> {
            greetingRepository.save(new Greeting("Hola"));
            greetingRepository.save(new Greeting("Hi"));
        };

    }
}

@RestController
class HelloController {
    private final Greeting.GreetingRepository greetingRepository;

    HelloController(Greeting.GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @GetMapping("/")
    String hello() {
        return "Hello World";
    }

    @GetMapping("/greetings")
    List<Greeting> greetings() {
        return (List<Greeting>) greetingRepository.findAll();
    }

}

@Entity
class Greeting {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String message;

    public Greeting() {
    }

    public Greeting(String message) {
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    interface GreetingRepository extends CrudRepository<Greeting, Long> {
    }
}
