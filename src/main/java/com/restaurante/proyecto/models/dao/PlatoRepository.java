package com.restaurante.proyecto.models.dao;


import com.restaurante.proyecto.models.entity.Greeting;
import com.restaurante.proyecto.models.entity.Plato;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import javax.management.Query;


public interface PlatoRepository extends CrudRepository<Plato, Long> {
}