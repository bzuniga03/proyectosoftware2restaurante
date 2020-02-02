package com.restaurante.proyecto.models.dao;


import com.restaurante.proyecto.models.entity.CategoriaEntity;
import com.restaurante.proyecto.models.entity.PlatoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface PlatoRepository extends CrudRepository<PlatoEntity, Long> {

    @Query("select p from PlatoEntity p where p.categoriaByPtlCategoria=?1")
    List<PlatoEntity> platoporCategoria(CategoriaEntity categoria);

}