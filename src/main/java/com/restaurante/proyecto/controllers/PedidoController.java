package com.restaurante.proyecto.controllers;


import com.restaurante.proyecto.controllers.objetos.ObjetoPedido;
import com.restaurante.proyecto.controllers.objetos.ObjetoPlato;
import com.restaurante.proyecto.models.dao.CategoriaRepository;
import com.restaurante.proyecto.models.dao.DetallePedidoRepository;
import com.restaurante.proyecto.models.dao.PedidoRepository;
import com.restaurante.proyecto.models.entity.DetallePedidoEntity;
import com.restaurante.proyecto.models.entity.PedidoEntity;
import com.restaurante.proyecto.models.entity.PlatoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
class PedidoController {
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

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
                listaPedidos.append(detallePedidoEntity.getPlatoEntity().getPtlDescripcion()).append(",");
            }

            objetoPedido.setPlatos(listaPedidos.toString());

            pedidos.add(objetoPedido);

        }
        return pedidos;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/cerrarPedido/{numeroPedido}")
    public boolean cerrarPedido(@PathVariable int numeroPedido) {

        boolean ret = false;
        Optional<PedidoEntity> pedidoEntity = pedidoRepository.findById(numeroPedido);

        if (pedidoEntity.isPresent()) {
            pedidoEntity.get().setPddEstado("C");
            pedidoRepository.save(pedidoEntity.get());
            ret = true;
        }

        return ret;
    }

}