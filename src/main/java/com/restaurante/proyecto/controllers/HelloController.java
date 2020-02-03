package com.restaurante.proyecto.controllers;


import com.restaurante.proyecto.models.dao.GreetingRepository;
import com.restaurante.proyecto.models.entity.GreetingEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class HelloController {
    @Autowired
    private GreetingRepository greetingRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/")
    String hello() {
        return "Hello World";
    }

    @GetMapping("/greetings")
    List<GreetingEntity> greetings() {
        return (List<GreetingEntity>) greetingRepository.findAll();
    }
}