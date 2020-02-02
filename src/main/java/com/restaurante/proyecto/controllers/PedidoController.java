package com.restaurante.proyecto.controllers;


import com.restaurante.proyecto.controllers.objetos.ObjetoPedido;
import com.restaurante.proyecto.controllers.objetos.ObjetoPlato;
import com.restaurante.proyecto.models.dao.CategoriaRepository;
import com.restaurante.proyecto.models.dao.DetallePedidoRepository;
import com.restaurante.proyecto.models.dao.PedidoRepository;
import com.restaurante.proyecto.models.entity.DetallePedidoEntity;
import com.restaurante.proyecto.models.entity.PedidoEntity;
import com.restaurante.proyecto.models.entity.PlatoEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
class PedidoController {
    private final PedidoRepository pedidoRepository;
    private final DetallePedidoRepository detallePedidoRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/obtenerPedidos")
    List<ObjetoPedido> obtenerPedido() {

        List<ObjetoPedido> pedidos = new ArrayList<>();

        List<PedidoEntity> pedidosAbiertos = pedidoRepository.PedidosAbiertos();

        for (PedidoEntity pedidoEntity : pedidosAbiertos) {
            ObjetoPedido objetoPedido = new ObjetoPedido();

            objetoPedido.setIdPedido(pedidoEntity.getPddId());
            objetoPedido.setComentarioPedido(pedidoEntity.getPddComentario());
            objetoPedido.setMesa((long) pedidoEntity.getMesaByPddMesa().getMsaId());

            List<DetallePedidoEntity> pedidoEntityList = detallePedidoRepository.detallePorPedido(pedidoEntity);

            StringBuilder listaPedidos = new StringBuilder();
            for (DetallePedidoEntity detallePedidoEntity : pedidoEntityList) {
                listaPedidos.append(detallePedidoEntity.getPlatoEntity().getPtlDescripcion());

            }

            objetoPedido.setPlatos(listaPedidos.toString());

            pedidos.add(objetoPedido);

        }
        return pedidos;
    }

    PedidoController(PedidoRepository pedidoRepository, DetallePedidoRepository detallePedidoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.detallePedidoRepository = detallePedidoRepository;
    }

}