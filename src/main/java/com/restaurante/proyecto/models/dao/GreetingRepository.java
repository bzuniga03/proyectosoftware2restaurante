package com.restaurante.proyecto.models.dao;


import com.restaurante.proyecto.models.entity.Greeting;
import org.springframework.data.repository.CrudRepository;

public interface GreetingRepository extends CrudRepository<Greeting, Long> {
}