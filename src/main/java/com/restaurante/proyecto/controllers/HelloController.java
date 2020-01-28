package com.restaurante.proyecto.controllers;


import com.restaurante.proyecto.models.dao.GreetingRepository;
import com.restaurante.proyecto.models.entity.Greeting;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class HelloController {
    private final GreetingRepository greetingRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/")
    String hello() {
        return "Hello World";
    }

    @GetMapping("/greetings")
    List<Greeting> greetings() {
        return (List<Greeting>) greetingRepository.findAll();
    }

    HelloController(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

}