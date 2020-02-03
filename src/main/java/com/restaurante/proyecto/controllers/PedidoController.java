package com.restaurante.proyecto.controllers;


import com.google.gson.Gson;
import com.restaurante.proyecto.controllers.objetos.ObjetoIngresoPedido;
import com.restaurante.proyecto.controllers.objetos.ObjetoPedido;
import com.restaurante.proyecto.models.dao.DetallePedidoRepository;
import com.restaurante.proyecto.models.dao.MesaRepository;
import com.restaurante.proyecto.models.dao.PedidoRepository;
import com.restaurante.proyecto.models.dao.PlatoRepository;
import com.restaurante.proyecto.models.entity.DetallePedidoEntity;
import com.restaurante.proyecto.models.entity.MesaEntity;
import com.restaurante.proyecto.models.entity.PedidoEntity;
import com.restaurante.proyecto.models.entity.PlatoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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
    @Autowired
    private MesaRepository mesaRepository;
    @Autowired
    private PlatoRepository platoRepository;

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
            objetoPedido.setEstado(pedidoEntity.getPddEstado());

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

    @Transactional
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/ingresarPedido")
    public Boolean ingresarPedido(@RequestBody String pedidoJson) {
        boolean ret = false;
        Gson gson = new Gson();

        System.out.println(pedidoJson);

        ObjetoIngresoPedido objetoIngresoPedido = gson.fromJson(pedidoJson, ObjetoIngresoPedido.class);

        if (objetoIngresoPedido != null) {
            PedidoEntity pedidoEntity = new PedidoEntity();
            Optional<MesaEntity> mesaEntity;

            pedidoEntity.setPddEstado("A");
            pedidoEntity.setPddComentario(objetoIngresoPedido.getComentarioPedido());
            mesaEntity = mesaRepository.findById(objetoIngresoPedido.getMesa());

            if (mesaEntity.isPresent()) {
                pedidoEntity.setMesaByPddMesa(mesaEntity.get());
            } else {
                return ret;
            }

            pedidoEntity = pedidoRepository.save(pedidoEntity);

            for (ObjetoIngresoPedido.detallePlato detalle : objetoIngresoPedido.getPlatos()) {

                DetallePedidoEntity detallePedidoEntity = new DetallePedidoEntity();

                Optional<PlatoEntity> platoEntity;
                platoEntity = platoRepository.findById((long) detalle.getId());

                if (!platoEntity.isPresent())
                    return ret;

                detallePedidoEntity.setPlatoEntity(platoEntity.get());
                detallePedidoEntity.setPedidoEntity(pedidoEntity);

                detallePedidoRepository.save(detallePedidoEntity);
            }

            ret = true;
        }

        return ret;
    }

}