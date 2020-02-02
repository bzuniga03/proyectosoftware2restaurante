package com.restaurante.proyecto.models.dao;


import com.restaurante.proyecto.models.entity.CategoriaEntity;
import org.springframework.data.repository.CrudRepository;

public interface CategoriaRepository extends CrudRepository<CategoriaEntity, Long> {
}