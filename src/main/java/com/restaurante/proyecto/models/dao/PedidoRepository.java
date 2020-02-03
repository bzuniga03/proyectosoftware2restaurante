package com.restaurante.proyecto.models.dao;


import com.restaurante.proyecto.models.entity.PedidoEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface PedidoRepository extends CrudRepository<PedidoEntity, Integer> {

    @Query("select p from PedidoEntity p where p.pddEstado= 'A'")
    List<PedidoEntity> PedidosAbiertos();
}