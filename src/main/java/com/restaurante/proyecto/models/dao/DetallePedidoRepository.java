package com.restaurante.proyecto.models.dao;


import com.restaurante.proyecto.models.entity.DetallePedidoEntity;
import com.restaurante.proyecto.models.entity.PedidoEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface DetallePedidoRepository extends CrudRepository<DetallePedidoEntity, Long> {

    @Query("select d from DetallePedidoEntity d where d.pedidoEntity=?1")
    List<DetallePedidoEntity> detallePorPedido(PedidoEntity pedidoEntity);

}