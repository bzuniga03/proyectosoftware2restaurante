package com.restaurante.proyecto.models.dao;


import com.restaurante.proyecto.models.entity.Categoria;
import com.restaurante.proyecto.models.entity.Plato;
import org.springframework.data.repository.CrudRepository;

public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
}