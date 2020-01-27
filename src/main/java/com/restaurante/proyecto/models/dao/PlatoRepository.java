package com.restaurante.proyecto.models.dao;


import com.restaurante.proyecto.models.entity.Categoria;
import com.restaurante.proyecto.models.entity.Greeting;
import com.restaurante.proyecto.models.entity.Plato;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface PlatoRepository extends CrudRepository<Plato, Long> {

    @Query("select p from Plato p where p.ptl_categoria=?1")
    List<Plato> platoporCategoria(Categoria categoria);

}